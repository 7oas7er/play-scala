# Cloudflare — Netrunner

Manages **DNS only** for `netrunner.7oas7er.com` and `netrunner-stg.7oas7er.com` on the shared `7oas7er.com` zone.

Zone-level rulesets (origin-verify transform, cache settings) and `ssl` mode are already owned by **Block Drop**’s Cloudflare root. IAM/Cloudflare allow only **one zone ruleset per phase**, so a second Terraform root must not create competing rulesets.

## Auth (required)

The provider reads **`CLOUDFLARE_API_TOKEN`** from the environment (not from `terraform.tfvars`):

```bash
export AWS_PROFILE=7oas7er
export CLOUDFLARE_API_TOKEN=…   # same token you use for Block Drop CF apply / GitHub CLOUDFLARE_API_TOKEN

cd infra/terraform/cloudflare
cp terraform.tfvars.example terraform.tfvars   # fill CloudFront domains + origin secrets (for docs below)
terraform init
terraform apply
```

Token needs at least: Zone.DNS Edit, Zone.Read (and Cache Purge for deploy). For adding origin-verify rules in the dashboard / Block Drop root, also Transform Rules Edit.

Without `CLOUDFLARE_API_TOKEN`, apply fails with `Missing X-Auth-Key, X-Auth-Email or Authorization headers`.

## Origin-verify + cache (shared zone)

Owned by **Block Drop**’s Cloudflare root (`7oas7er/block-drop`). After Netrunner DNS applies, merge/apply that repo’s PR that adds Netrunner host rules (branch `cursor/netrunner-origin-verify-rules` or successor), then locally:

```bash
# in block-drop checkout
cd infra/terraform/cloudflare
# set netrunner_stg_origin_verify_secret / netrunner_prod_origin_verify_secret
# to the same values as play-scala AWS origin_verify_secret (stg / prod)
export CLOUDFLARE_API_TOKEN=…
terraform apply
```

| Hostname | Secret source |
|----------|----------------|
| `netrunner-stg.7oas7er.com` | play-scala `envs/stg` `origin_verify_secret` |
| `netrunner.7oas7er.com` | play-scala `envs/prod` `origin_verify_secret` |
