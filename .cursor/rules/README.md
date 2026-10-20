# Cursor rules — platform vs product

Rules split so this repo can be cloned as a **solo + AI** template without fighting product-specific names forever.

| Kind | Prefix | Role |
|------|--------|------|
| **Platform** | `app-*` | Public web app in **one AWS account**, Cloudflare edge, Grafana-first, Terraform SoT |
| **Product** | `netrunner-*` | This catalog app (static `netrunner/`, domains, naming) |

When cloning for a new app: keep `app-*`, replace or delete `netrunner-*`, and follow the skill `.cursor/skills/new-app-from-template/`.

## Files

| Rule | Scope |
|------|--------|
| `app-core.mdc` | always — hosting, envs, secrets, Cloudflare-only, agents |
| `app-aws-regions.mdc` | always — `eu-north-1` default |
| `app-observability.mdc` | always — Grafana pattern |
| `app-terraform.mdc` | `infra/terraform/**` — roots, state, CI plan |
| `app-deploy.mdc` | `.github/workflows/**` — OIDC deploy / promote |
| `netrunner-core.mdc` | always — product + pointers to platform |
| `netrunner-frontend.mdc` | `netrunner/**` |
| `netrunner-terraform.mdc` | `infra/terraform/**` — naming, domains |
| `netrunner-deploy.mdc` | `.github/workflows/**` — this app’s workflow |
| `netrunner-observability.mdc` | always — this app’s labels / dashboard path |
