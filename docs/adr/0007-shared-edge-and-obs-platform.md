# 0007 — Shared edge and observability platform

- **Status:** accepted
- **Date:** 2026-10-21

## Context

Netrunner shares zone `7oas7er.com` and a Grafana Cloud Free stack with Block Drop. Putting origin-verify / Infinity / GitHub plugin ownership inside Block Drop made this app implicitly depend on that repo.

## Decision

Shared zone policy and shared Grafana objects live in [`7oas7er/platform`](https://github.com/7oas7er/platform). This app’s Cloudflare root is DNS-only; Grafana does not create Infinity or install the GitHub plugin. Canonical ADR: platform `docs/adr/0001-shared-edge-and-obs.md`.

## Consequences

- Dependency graph is **app → platform**, never Netrunner → Block Drop.
- Agents must not recreate zone rulesets or Infinity / GitHub plugin installs here.
- New host origin-verify secrets go in platform `shared-edge` tfvars.
