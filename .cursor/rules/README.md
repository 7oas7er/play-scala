# Cursor rules — platform vs product

Rules split so this repo can be cloned as a **solo + AI** template without fighting product-specific names forever.

**Naming note:** Cursor `app-*` rules are the **in-repo app pattern**. The **GitHub platform repository** [`7oas7er/platform`](https://github.com/7oas7er/platform) holds shared-edge + shared-obs. Do not conflate the two. Architecture: [`docs/architecture.md`](../../docs/architecture.md).

| Kind | Prefix | Role |
|------|--------|------|
| **App pattern** | `app-*` | Public web app in **one AWS account**, DNS-only Cloudflare in-app, Grafana-first, Terraform SoT; depends on `7oas7er/platform` |
| **Product** | `netrunner-*` | This catalog app (static `netrunner/`, domains, naming) |

When cloning for a new app: keep `app-*`, replace or delete `netrunner-*`, wire hosts into platform `shared-edge`, and follow Block Drop’s `new-app-from-template` skill.

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
