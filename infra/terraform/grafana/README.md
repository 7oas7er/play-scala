# Netrunner — Grafana Cloud observability

Observability for Netrunner lives in **Grafana Cloud Free** (synthetics, CloudWatch scrape, Cloudflare edge analytics via GraphQL, GitHub Actions). Cloudflare stays DNS/edge only — metrics are **pulled into** Grafana; do not add a second monitoring SaaS in Cloudflare.

CloudWatch scrape is enabled by default (`enable_cloudwatch_scrape = true`). Org RCP `ManagedAccountResourceControlPolicy` must exempt Grafana Labs account `008923505280` from the outside-org `sts:*` deny, or AssumeRole fails with `aws_authentication_error`.

## What this root manages

| Resource | Purpose |
|----------|---------|
| `shared-netrunner-grafana-cloudwatch-role` | IAM role Grafana Labs assumes to read CloudWatch |
| `grafana_cloud_provider_aws_account` | Links the AWS account to the Grafana stack |
| `grafana_cloud_provider_aws_cloudwatch_scrape_job` | Scrapes Lambda + CloudFront metrics |
| Synthetic HTTP checks | Prod/stg site (prod: ≤2 EU probes @ 5m; stg: 1 probe @ 15m) |
| Infinity data source | Cloudflare GraphQL edge traffic + firewall / rate-limit events (optional until token set) |
| GitHub data source | Actions workflow runs / usage for deploy + terraform-plan (optional until token set) |
| Folder + dashboard `Netrunner` | Synthetics + CloudWatch + Cloudflare edge + GitHub CI |

State key: `grafana/terraform.tfstate` in `shared-netrunner-terraform-state-bucket`.

## One-time Grafana setup

1. Create a [Grafana Cloud Free](https://grafana.com/products/cloud/) account and stack.
2. Create a Cloud access policy token with `stacks:read`, `stack-service-accounts:write` (for dashboards), `stack-plugins:read|write|delete` (to install the GitHub plugin), and `integration-management:read|write` for Cloud Provider (or a separate token). Infinity is pre-provisioned on Grafana Cloud — do not try to install it via Terraform (API returns 409).
3. In the stack: **Synthetics → Config** — create an SM access token (`sm_access_token`).
4. Copy `terraform.tfvars.example` → `terraform.tfvars` and fill values (never commit `terraform.tfvars`).
   - IAM trust External ID defaults to the stack `prometheus_user_id`. If account create fails with `aws_authentication_error` and CloudTrail shows no `AssumeRole`, copy the External ID from **Cloud Provider → AWS → Add account** into `grafana_aws_external_id`.
   - Cloud Provider API URL comes from the stack `cloud_provider_url` automatically (do not invent it from `region_slug`; they can differ).
   - Terraform creates a stack service account `netrunner-terraform` to publish the Netrunner dashboard.

### Cloudflare edge analytics (Free plan)

The official Grafana Cloudflare integration needs Cloudflare **Business/Enterprise**. On Free, use GraphQL via the Infinity data source instead.

1. Cloudflare → **My Profile → API Tokens → Create Token**.
   - Use a token with **Zone → Analytics → Read** (and Zone → Zone → Read if prompted).
   - Scope it to zone `7oas7er.com`.
2. Set `cloudflare_analytics_token` in `terraform.tfvars` (or `CLOUDFLARE_ANALYTICS_TOKEN`).
3. Set `cloudflare_zone_tag` to the zone id (`cd ../cloudflare && terraform output -raw zone_id`, or Zone ID in the Cloudflare overview).
4. Probe datasets (expect `enabled: true` for `httpRequestsAdaptiveGroups` and `firewallEventsAdaptive`):

```bash
export CLOUDFLARE_API_TOKEN='...'   # Analytics Read token
export CLOUDFLARE_ZONE_TAG='...'    # zone id
./scripts/probe-cloudflare-graphql.sh
```

   On Cloudflare **Free**, `firewallEventsAdaptiveGroups` stays disabled — the dashboard uses HTTP status 403/429 from `httpRequestsAdaptiveGroups` plus the `firewallEventsAdaptive` event table instead.

5. `terraform apply` — creates Infinity DS `infinity-cloudflare`. On the dashboard, confirm the **CF zoneTag** variable is populated (`701810fff825f90c0eea671970a0cc9e` for `7oas7er.com`).

### GitHub Actions CI

1. Create a fine-grained PAT for repo `7oas7er/netrunner` with **Actions: Read**, **Metadata: Read**, and **Contents: Read** if the plugin requires it.
2. Set `github_access_token` in `terraform.tfvars` (or `GITHUB_GRAFANA_TOKEN`).
3. `terraform apply` — installs the `grafana-github-datasource` Cloud plugin (not present by default), then creates DS `github-netrunner`. Without the plugin install, the dashboard GitHub variable shows **No data sources found**.
4. Dashboard panels cover `deploy-netrunner.yml` and `terraform-plan.yml`.

Without these tokens, synthetics + CloudWatch still apply; Cloudflare/GitHub data sources (and the GitHub plugin) are skipped.

## Apply

```bash
cd infra/terraform/grafana
cp terraform.tfvars.example terraform.tfvars   # first time
terraform init
terraform plan
terraform apply
```

AWS profile: `7oas7er`. Tokens may also be supplied via `GRAFANA_*` env vars where the provider supports them.

## Notes

- Set `enable_cloudwatch_scrape = false` in `terraform.tfvars` to remove the Cloud Provider AWS account + scrape job without deleting the IAM role.
- Set `enable_cloudflare_edge = false` / `enable_github_ci = false` to skip those data sources even if tokens are present.
- CloudWatch scrape covers `eu-north-1` and `us-east-1` (CloudFront metrics).
- Tagged AWS resources (`Name` tags on Netrunner) improve metric discovery.
- Shipping CloudWatch **Logs** into Grafana Cloud Logs is a follow-up (not required for the first scrape + synthetics setup).
