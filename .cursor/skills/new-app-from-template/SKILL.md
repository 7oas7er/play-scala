---
name: new-app-from-template
description: >-
  Bootstraps a new solo+AI public web app from the Netrunner template pattern
  (AWS one account, Cloudflare edge, Grafana-first, Terraform SoT). Use when
  cloning this repo, starting a new app from the template, renaming project
  slugs, or walking first apply / first PR / promote-to-main.
---

# New app from template

Source pattern: this repo (`netrunner` + `app-*` Cursor rules). Read `.cursor/rules/README.md` first.

## Preconditions

- One AWS account, profile `7oas7er` (or update docs/rules to the new profile).
- Cloudflare zone you control; Grafana Cloud Free stack.
- GitHub repo with Environments `staging`, `production`, `terraform`.

## Checklist (copy and tick)

```
New app progress:
- [ ] 1. Copy / clone layout
- [ ] 2. Rename product (paths, slug, domains)
- [ ] 3. Cursor rules (keep app-*, replace product overlays)
- [ ] 4. Terraform state keys + resource names
- [ ] 5. Grafana labels / folder / dashboard
- [ ] 6. GitHub Environments + OIDC subjects
- [ ] 7. First local applies (bootstrap → stg → cloudflare → grafana)
- [ ] 8. First PR → staging
- [ ] 9. First promote staging → main
```

### 1. Copy layout

Keep: `infra/terraform/{aws,cloudflare,grafana}/`, `infra/lambda/` (or replace with your API), `.github/workflows/`, `tests/`, `docs/adr/`, `AGENTS.md`, `SECURITY.md`, `app-*` rules.

Replace or empty: product static tree (`netrunner/` → your app dir), product dashboard JSON, product-specific ADRs if wrong.

### 2. Rename product

Pick an **app slug** (e.g. `my-app`) and domains.

- Rename static dir; update deploy workflow paths and Dependabot directories.
- Search-replace Terraform locals / names: `netrunner` → slug; update state bucket name if creating fresh state.
- Domains in Cloudflare + ACM + GitHub `SITE_HOST`.
- Update `README.md`, `AGENTS.md`, product Cursor rules, Grafana `project=` label.

### 3. Cursor rules

- **Keep** all `app-*.mdc`.
- **Replace** `netrunner-*.mdc` with `<slug>-*.mdc` (or one thin `product-core` + frontend/terraform overlays).
- Update `.cursor/rules/README.md` table.
- Do not leave conflicting alwaysApply rules that restate opposite platform choices.

### 4. Terraform state

- New state bucket **or** new key prefixes under an existing bucket (never reuse another app’s `envs/prod/` key).
- Keys typically: `bootstrap/`, `envs/stg/`, `envs/prod/`, `cloudflare/`, `grafana/`.
- Fresh `terraform.tfvars` (gitignored) per root; never copy prod secrets from another app.

### 5. Grafana

- New folder + dashboard; label `project=<slug>`.
- Synthetics for site + critical API paths.
- New stack service account name if publishing via Terraform.
- Cloudflare analytics token scoped to the right zone.

### 6. GitHub Environments

| Environment | Points at |
|-------------|-----------|
| `staging` | stg deploy role, stg bucket/distribution/host/zone |
| `production` | prod deploy role, prod bucket/distribution/host/zone |
| `terraform` | plan role + plan-time vars/secrets |

OIDC trust subjects must match `environment:…`. Distinct resources per env — see `docs/adr/0006-github-env-separation.md`.

### 7. First local applies

Order (adjust if bootstrap already exists):

```bash
export AWS_PROFILE=7oas7er
# 1) bootstrap (state bucket) if new
# 2) aws/envs/stg  (site + OIDC + plan role)
# 3) cloudflare    (DNS + origin-verify for stg)
# 4) grafana       (synthetics/dashboard; may need stg URLs)
# 5) aws/envs/prod after stg is proven
```

Confirm Cloudflare-only gate (raw CloudFront URL 403; custom domain 200).

### 8. First PR → staging

- Branch from `staging`; small first PR (docs or no-op path under app dir).
- Require green: `Required CI`, tests if site paths change, terraform plan/Checkov if infra changes.
- Merge; confirm stg deploy + synthetics.

### 9. First promote → main

- Open PR `staging` → `main` only when stg is healthy.
- After merge: prod deploy; local `terraform apply` for prod roots if infra differed; confirm prod synthetics.

## Anti-patterns

- Pointing `staging` and `production` GitHub Environments at the same role/bucket.
- Adding a second monitoring SaaS or CI `terraform apply` without a new ADR.
- Copying `terraform.tfvars` or state between apps.
- Leaving `netrunner-*` alwaysApply rules that contradict the new product.

## References

- `.cursor/rules/README.md`
- `docs/adr/` (especially 0003 local apply, 0005 Cloudflare-only, 0006 env separation)
- `SECURITY.md`, `infra/terraform/docs/origin-verify-secret-rotation.md`
- `docs/template-readiness-backlog.md`
