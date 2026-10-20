# First local apply — Netrunner

Operator checklist after this repo’s template transplant. Apply stays on your machine (`AWS_PROFILE=7oas7er`). CI never applies.

## Preconditions

- [ ] One AWS account; profile `7oas7er` configured
- [ ] ACM certificate in **us-east-1** for `netrunner-stg.7oas7er.com` (and later `netrunner.7oas7er.com`)
- [ ] Cloudflare zone `7oas7er.com` (shared with other apps — this root only manages Netrunner hostnames)
- [ ] Grafana Cloud Free stack
- [ ] GitHub Environments on `7oas7er/play-scala`: `staging`, `production`, `terraform`
- [ ] Fresh state bucket name (default) `shared-netrunner-terraform-state-bucket` — **do not** reuse Block Drop state keys
- [ ] Same AWS account as Block Drop is fine; filter console/Cost Explorer by tag `Project=netrunner`

## OIDC subjects (defaults in Terraform)

```
repo:7oas7er@2952810/play-scala@87063790:environment:staging
repo:7oas7er@2952810/play-scala@87063790:environment:production
repo:7oas7er@2952810/play-scala@87063790:environment:terraform
```

Confirm against the GitHub OIDC claim after the Environments exist; update `github_actions_subject` / `github_actions_plan_subject` if GitHub’s subject format differs.

## Apply order

```bash
export AWS_PROFILE=7oas7er

# 1) Bootstrap state bucket (once)
cd infra/terraform/aws/bootstrap
cp terraform.tfvars.example terraform.tfvars   # edit if needed
terraform init && terraform apply

# 2) Staging site + OIDC + plan role
cd ../envs/stg
cp terraform.tfvars.example terraform.tfvars   # cert ARN, origin-verify secret
terraform init && terraform apply

# 3) Cloudflare DNS + origin-verify + cache for Netrunner hosts
cd ../../../cloudflare
cp terraform.tfvars.example terraform.tfvars   # CF domains from stg/prod outputs
terraform init && terraform apply

# 4) Grafana synthetics / dashboard
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
