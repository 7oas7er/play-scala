# Netrunner AWS Terraform

One AWS account, two environments:

| Env | Root | Hostname |
|-----|------|----------|
| Staging | [`envs/stg`](envs/stg) | `netrunner-stg.7oas7er.com` |
| Production | [`envs/prod`](envs/prod) | `netrunner.7oas7er.com` |

Shared module: [`modules/site`](modules/site). The GitHub Actions OIDC provider is **account-wide** (IAM allows one per issuer URL). Stg and prod both look it up with a data source — required when sharing the AWS account with Block Drop.

Bootstrap root: [`bootstrap`](bootstrap) creates the shared S3 state bucket. It uses a **local** backend (see [`bootstrap/README.md`](bootstrap/README.md)) so the first apply is not blocked by a missing remote bucket.

## Remote state

State is stored in S3 (not git):

| Root | State |
|------|--------|
| `bootstrap` | **Local** `bootstrap/terraform.tfstate` (gitignored) |
| `envs/stg` | S3 key `envs/stg/terraform.tfstate` |
| `envs/prod` | S3 key `envs/prod/terraform.tfstate` |
| `../cloudflare` | S3 key `cloudflare/terraform.tfstate` |
| `../grafana` | S3 key `grafana/terraform.tfstate` |

- Bucket (for non-bootstrap roots): `shared-netrunner-terraform-state-bucket` (versioned, encrypted, private; Netrunner-only — do not reuse Block Drop’s state bucket)
- Locking: S3 native lock files (`use_lockfile = true`); requires Terraform **>= 1.10**
- After changing backend lock settings, run `terraform init -reconfigure` in that root

After cloning the repo on a new machine, run `terraform init` in each root (with AWS profile `7oas7er`). No local state copy is required.

Local `*.tfstate` / `*.tfstate.*` files remain gitignored. Old local backups under each env can be deleted once you are satisfied the remote state is correct.

## Resource naming

AWS resource names follow:

`[environment]-netrunner-[purpose]-[resource-type]`

Examples for `stg`:

- `stg-netrunner-site-bucket`
- `stg-netrunner-access-logs-bucket`
- `stg-netrunner-site-5xx-alarm`
- `stg-netrunner-github-deploy-role`
- `stg-netrunner-site-oac`
- `stg-netrunner-site-distribution` (CloudFront comment / `Name` tag)

Shared bootstrap resources use `shared` as the environment segment.

## Tags

Provider `default_tags` (bootstrap, stg, prod, and the Grafana root’s AWS provider) apply to all taggable resources:

| Key | Value |
|-----|--------|
| `Project` | `netrunner` |
| `Environment` | `stg` / `prod` / `shared` |

Use `Project=netrunner` in the AWS console (or Cost Explorer) to separate this app from Block Drop in the same account. Resources may also carry a per-resource `Name` tag.

Renaming named resources (buckets, roles, OACs) forces Terraform to replace them. Copy site objects to the new buckets before destroying the old ones, and update GitHub Actions `AWS_*` variables after the prod deploy role / bucket names change. The site bucket is not versioned — `netrunner/` in git is the source of truth.

## Apply order

1. Apply **bootstrap** once per [`bootstrap/README.md`](bootstrap/README.md) (`terraform init -reconfigure` → `apply`). Skip if the state bucket already exists.
2. Create/validate an ACM certificate in `us-east-1` for `netrunner-stg.7oas7er.com` and set `site_certificate_arn` in `envs/stg/terraform.tfvars`.
3. Apply **stg**.
4. Apply Cloudflare with `stg_cloudfront_domain_name` set to the stg `distribution_domain_name` output.
5. Apply **prod**.
6. Point Cloudflare `prod_cloudfront_domain_name` at the prod distribution.
7. Put Terraform deploy outputs into GitHub Environments: `staging` ← stg outputs, `production` ← prod outputs (`AWS_DEPLOY_ROLE_ARN`, `AWS_REGION`, `AWS_SITE_BUCKET`, `AWS_DISTRIBUTION_ID`). Also set `SITE_HOST` (`netrunner-stg.7oas7er.com` / `netrunner.7oas7er.com`), `CLOUDFLARE_ZONE_ID` (Cloudflare `zone_id` output), and secret `CLOUDFLARE_API_TOKEN` (Zone Cache Purge) so deploy can purge the Cloudflare edge.
8. Deploy path: merge to `staging` for stg; merge `staging` → `main` for prod. OIDC subjects match the GitHub Environments (`…:environment:staging` / `…:environment:production`); lock Environments to those branches in GitHub deployment rules.

## Access logging

Each env module creates a private `{env}-netrunner-access-logs-bucket` (SSE-S3, Block Public Access, 90-day lifecycle):

- **CloudFront** standard logging **v2** (CloudWatch Logs delivery → S3 prefix `cloudfront/`; delivery APIs in `us-east-1`, bucket in `eu-north-1`). Uses JSON output (not Parquet) to avoid conversion charges.
- **S3 site bucket** server access logs → prefix `s3-site/`.

## CloudWatch alarms

- Metric alarm (no SNS yet — visible in the CloudWatch console; Grafana remains the primary external monitor):
  - CloudFront **5xxErrorRate** > 5% (us-east-1, Global dimension)

## Cloudflare origin verify

CloudFront rejects requests that lack a matching `X-Origin-Verify` header. Cloudflare Transform Rules inject that header for the Netrunner hostnames, so only orange-cloud traffic is accepted. Direct `*.cloudfront.net` URLs return 403.

- Set the same value in `envs/stg` `origin_verify_secret` and Cloudflare `stg_origin_verify_secret`.
- Set the same value in `envs/prod` `origin_verify_secret` and Cloudflare `prod_origin_verify_secret`.
- Prefer distinct secrets per environment. Store them only in local `terraform.tfvars` (gitignored).
- Apply Cloudflare **before** enabling/updating the CloudFront Function gate so legitimate traffic is never locked out.
- **Rotation**: follow [origin-verify secret rotation](../docs/origin-verify-secret-rotation.md) (dual-accept via optional `origin_verify_secret_previous`, then switch Cloudflare, then drop the previous secret).
- GitHub Actions S3 sync, CloudFront invalidation, and Cloudflare cache purge do not use the viewer path and are unaffected.
- Cloudflare cache rules (`infra/terraform/cloudflare/cache.tf`) respect origin `Cache-Control` for Netrunner hosts.
- www/apex DNS and redirects stay with Netrunner on the shared zone; this root only manages `netrunner` / `netrunner-stg` CNAMEs.

## Site package

Static catalog only (no Lambda). Publish `netrunner/` via GitHub Actions S3 sync + CloudFront invalidation.

## CI plan

GitHub Actions runs `terraform fmt` / `validate` / `plan` on infra changes (see [terraform-plan-ci.md](../docs/terraform-plan-ci.md)). Apply remains local. After creating the plan role, store `github_terraform_plan_role_arn` and related secrets on GitHub Environment **terraform**.

## Local commands

```bash
export AWS_PROFILE=7oas7er
cd bootstrap   # first time / changes to state backend resources
# or: cd envs/stg   # or envs/prod
cp terraform.tfvars.example terraform.tfvars   # first time, if needed
terraform init -reconfigure   # if you previously had profile= in the backend
terraform plan
terraform apply
```
