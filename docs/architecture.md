# Architecture — Netrunner in the solo+AI platform

## Fundamental split

**Each app is an isolated repository.** Shared multi-tenant edge and Grafana Free objects live in [`7oas7er/platform`](https://github.com/7oas7er/platform). This app depends on platform; it must **not** depend on Block Drop.

```text
7oas7er/platform  (shared-edge, shared-obs)
        ▲
        │  app → platform only
        │
   play-scala (this repo)     block-drop / future apps
```

Full platform write-up: [platform docs/architecture.md](https://github.com/7oas7er/platform/blob/main/docs/architecture.md). Decision: [ADR 0007](adr/0007-shared-edge-and-obs-platform.md) (mirrors platform ADR 0001).

## What this repo owns

| Path | Role |
|------|------|
| `netrunner/` | Static catalog |
| `infra/terraform/aws/` | S3, CloudFront, OIDC deploy/plan |
| `infra/terraform/cloudflare/` | **DNS only** for Netrunner hosts |
| `infra/terraform/grafana/` | Folder, dashboard, synthetics, CloudWatch scrape, GitHub DS |
| `.github/workflows/` | Tests, deploy, terraform plan (never apply) |

## What platform owns (do not recreate here)

- Zone rulesets: origin-verify, cache, SSL (and any Netrunner host rules)
- Shared Infinity DS `infinity-cloudflare` and GitHub catalog **plugin**

## Traffic path

Browser → Cloudflare (custom domain) → inject `X-Origin-Verify` → CloudFront → S3. Direct CloudFront URLs return 403.

Template pattern / cloning: Block Drop skill `new-app-from-template` (same isolation rules).
