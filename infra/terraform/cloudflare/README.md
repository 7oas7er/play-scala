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

## Origin-verify (shared zone)

After AWS stg/prod have `origin_verify_secret`, add **two** “Modify Request Header” rules to the **existing** zone transform ruleset (Block Drop’s “origin verify” ruleset), or add the same rules in [Block Drop’s `origin_verify.tf`](https://github.com/7oas7er/block-drop) and apply there:

| When hostname equals | Set header `X-Origin-Verify` to |
|----------------------|-----------------------------------|
| `netrunner-stg.7oas7er.com` | same value as stg AWS `origin_verify_secret` / `stg_origin_verify_secret` |
| `netrunner.7oas7er.com` | same value as prod AWS `origin_verify_secret` / `prod_origin_verify_secret` |

## Cache (optional)

If Block Drop’s cache ruleset is host-scoped to `blockdrop*`, add a matching “respect origin Cache-Control” rule for:

`http.host in {"netrunner.7oas7er.com" "netrunner-stg.7oas7er.com"}`

in that same Block Drop cache ruleset (or Cloudflare dashboard).
