# First local apply — Netrunner

Operator checklist after this repo’s template transplant. Apply stays on your machine (`AWS_PROFILE=7oas7er`). CI never applies. Ownership of edge/obs vs this app: [`docs/architecture.md`](architecture.md).

## Preconditions

- [ ] One AWS account; profile `7oas7er` configured
- [ ] ACM certificate in **us-east-1** for `netrunner-stg.7oas7er.com` (and later `netrunner.7oas7er.com`) — see [`docs/acm-certificates.md`](acm-certificates.md). Do **not** leave the `ACCOUNT_ID` / `CERTIFICATE_ID` placeholder in `terraform.tfvars`.
- [ ] Cloudflare zone `7oas7er.com` (DNS in this repo; zone rulesets in [`7oas7er/platform`](https://github.com/7oas7er/platform) `shared-edge`)
- [ ] Grafana Cloud Free stack
- [ ] GitHub Environments on `7oas7er/netrunner`: `staging`, `production`, `terraform`
- [ ] GitHub security floor applied + API-verified (`docs/github-branch-protection.md`) — mandatory on migrated repos
- [ ] Fresh state bucket name (default) `shared-netrunner-terraform-state-bucket` — **do not** reuse Block Drop state keys
- [ ] Same AWS account as Block Drop is fine; filter console/Cost Explorer by tag `Project=netrunner`

## OIDC subjects (defaults in Terraform)

This repo issues the classic GitHub Actions `sub` (confirmed in CloudTrail). Do **not** copy Block Drop’s `@ownerId/@repoId` form unless CloudTrail shows that format for this repo:

```
repo:7oas7er/netrunner:environment:staging
repo:7oas7er/netrunner:environment:production
repo:7oas7er/netrunner:environment:terraform
```

If `sts:AssumeRoleWithWebIdentity` fails, check CloudTrail `userIdentity.principalId` for the actual `sub` and update `github_actions_subject` / `github_actions_plan_subject`.

## Apply order

```bash
export AWS_PROFILE=7oas7er

# 1) Bootstrap state bucket (once). This root uses a *local* backend on purpose
#    (it creates the S3 bucket other roots use). See infra/terraform/aws/bootstrap/README.md
cd infra/terraform/aws/bootstrap
cp terraform.tfvars.example terraform.tfvars   # optional
# If a previous S3-backend init left .terraform confused: rm -rf .terraform
terraform init -reconfigure
terraform apply

# 2) Staging site + OIDC + plan role (S3 backend — bucket must exist from step 1)
cd ../envs/stg
cp terraform.tfvars.example terraform.tfvars
# Edit terraform.tfvars: real ISSUED ACM ARN (docs/acm-certificates.md) + origin_verify_secret
# *before* apply (avoids interactive prompts; interrupting apply leaves a stale state lock).
terraform init && terraform apply
# If you Ctrl+C mid-apply and see "Error acquiring the state lock":
#   terraform force-unlock <LOCK_ID>    # ID is printed in the error; only if no apply is still running

# 3) Cloudflare DNS for Netrunner hosts (DNS only; zone rulesets in 7oas7er/platform)
cd ../../../cloudflare
cp terraform.tfvars.example terraform.tfvars   # CF domains from stg output
export CLOUDFLARE_API_TOKEN=…                 # required — provider does not read this from tfvars
terraform init && terraform apply
# Origin-verify + cache: set netrunner_* secrets in platform shared-edge and apply there
# (https://github.com/7oas7er/platform)

# 4) Grafana synthetics / dashboard (Infinity + GitHub plugin: platform shared-obs)
cd ../grafana
cp terraform.tfvars.example terraform.tfvars
terraform init && terraform apply

# 5) Production AWS env after stg is proven
cd ../aws/envs/prod
cp terraform.tfvars.example terraform.tfvars
terraform init && terraform apply
```

## GitHub Environment vars (per env)

| Variable / secret | Source |
|-------------------|--------|
| `AWS_DEPLOY_ROLE_ARN` | `github_deploy_role_arn` output |
| `AWS_REGION` | `eu-north-1` |
| `AWS_SITE_BUCKET` | `bucket_name` |
| `AWS_DISTRIBUTION_ID` | `distribution_id` |
| `SITE_HOST` | `netrunner-stg.7oas7er.com` / `netrunner.7oas7er.com` |
| `CLOUDFLARE_ZONE_ID` | zone id |
| `CLOUDFLARE_API_TOKEN` | Zone.Cache Purge + Zone.Read |

Terraform Environment: plan-role ARN + plan-time vars per [`infra/terraform/docs/terraform-plan-ci.md`](../infra/terraform/docs/terraform-plan-ci.md).

## Verify

- [ ] Raw CloudFront URL → **403** (origin-verify)
- [ ] `https://netrunner-stg.7oas7er.com` → **200**, catalog loads
- [ ] Grafana synthetic for stg site green
- [ ] Merge a small PR to `staging` and confirm deploy workflow syncs S3
