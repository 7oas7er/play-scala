# 0001 — Static catalog delivery (no framework / bundler)

- **Status:** accepted
- **Date:** 2026-10-20

## Context

Netrunner is a personal card catalog with random starters/boosters. The highest leverage is readable card data and simple generators, not a SPA toolchain. This repo follows the Block Drop template’s static delivery decision.

## Decision

Ship the catalog as **static HTML, CSS, and plain JS** under `netrunner/` only. No framework, bundler, package manager, or build step for the site. Automated tests live under `tests/` (Node + Playwright) and gate deploy. Card CSV may be converted to JSON with a small Node script; that script is not a frontend build pipeline.

## Consequences

- Deploys are an S3 sync of files as written.
- Agents must not introduce React/Vite/etc. unless Frank explicitly overrides this ADR.
- Test tooling may use npm; the site tree must not.
