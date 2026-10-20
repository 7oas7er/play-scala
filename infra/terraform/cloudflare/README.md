# Cloudflare — Netrunner (DNS only)

Manages **DNS only** for `netrunner.7oas7er.com` and `netrunner-stg.7oas7er.com` on the shared `7oas7er.com` zone.

**Zone rulesets** (origin-verify, cache, SSL, etc.) are owned by [`7oas7er/platform`](https://github.com/7oas7er/platform) `shared-edge` — not by this app and not by Block Drop.

Cloudflare allows only **one zone ruleset per phase**; do not create competing rulesets here.

## Auth (required)

```bash
export AWS_PROFILE=7oas7er
export CLOUDFLARE_API_TOKEN=…   # Zone.DNS Edit, Zone.Read (+ Cache Purge for deploy)

cd infra/terraform/cloudflare
cp terraform.tfvars.example terraform.tfvars   # CloudFront domains
terraform init && terraform apply
```

## Origin-verify + cache

After AWS stg/prod have `origin_verify_secret`, set the matching vars in platform `shared-edge` and apply there:

| Hostname | Platform tfvars |
|----------|-----------------|
| `netrunner-stg.7oas7er.com` | `netrunner_stg_origin_verify_secret` |
| `netrunner.7oas7er.com` | `netrunner_prod_origin_verify_secret` |

See platform [docs/MIGRATION.md](https://github.com/7oas7er/platform/blob/main/docs/MIGRATION.md) for first-time import from legacy Block Drop state.
