# Agent definition of done — Netrunner

Instructions for Cursor (and similar) agents working in this repo. Platform rules: [`app-core.mdc`](.cursor/rules/app-core.mdc) (see [`.cursor/rules/README.md`](.cursor/rules/README.md)). Product overlay: [`netrunner-core.mdc`](.cursor/rules/netrunner-core.mdc). Architecture: [`docs/architecture.md`](docs/architecture.md). Decisions: [`docs/adr/`](docs/adr/). Secrets: [`SECURITY.md`](SECURITY.md). Cloning a new app: Block Drop skill `new-app-from-template` (same isolation + platform wiring).

## Defaults

- Prefer **small diffs** that match existing patterns. No drive-by refactors outside the task.
- Keep the catalog under `netrunner/` as **static HTML/CSS/plain JS** — no framework, bundler, package manager, or build step for the site.
- **Repo isolation**: do not depend on Block Drop for edge/obs. Shared edge/obs → [`7oas7er/platform`](https://github.com/7oas7er/platform) (`app → platform` only).
- **Terraform** is the source of truth for AWS / Cloudflare DNS / Grafana app objects. Do not reintroduce CDK or manage app resources with CloudFormation.
- **Observability**: Grafana Cloud only. Do not add Checkly, Datadog, New Relic, or similar unless Frank explicitly asks to replace Grafana. Shared Infinity DS + GitHub plugin: [`7oas7er/platform`](https://github.com/7oas7er/platform) `shared-obs`.
- **Cloudflare** app root is DNS only; zone rulesets live in platform `shared-edge`. Do not turn Cloudflare into a second monitoring product or default Workers platform for this app.
- Public apps must **only accept Cloudflare-fronted traffic**; reject direct origin access.
- **No auth / MySQL / Lambda** in the cards-only milestone unless Frank explicitly expands scope.

## GitHub workflow

- Feature work: branch → PR → **`staging`** (deploys AWS stg when site paths change).
- Production: PR **`staging` → `main`** only when asked to promote.
- Do **not** push or merge unless Frank asks. Do **not** force-push protected branches.
- Create commits only when asked; follow the repo’s commit / PR conventions.
- **Security floor** (Dependabot alerts, secret scanning + push protection, ruleset, default branch `main`, read-only `GITHUB_TOKEN`): apply and API-verify per [`docs/github-branch-protection.md`](docs/github-branch-protection.md) on every new or migrated app — copying this repo’s files is not enough.

## Terraform

- CI runs **fmt / validate / plan** only. **Never** add or run `terraform apply` in GitHub Actions unless Frank explicitly requests that change and an ADR supersedes [`docs/adr/0003-local-terraform-apply.md`](docs/adr/0003-local-terraform-apply.md).
- New irreversible platform choice → add a short ADR under [`docs/adr/`](docs/adr/).
- Apply locally with `AWS_PROFILE=7oas7er` when Frank asks.
- Never commit `.tfstate`, `terraform.tfvars`, API tokens, or AWS keys.

## Definition of done (checklist)

Before considering a task finished:

1. [ ] Change matches the request; no unrelated refactors.
2. [ ] Follows `.cursor/rules` for the area touched (`app-*` platform + `netrunner-*` product overlays).
3. [ ] No secrets or state files staged.
4. [ ] If `netrunner/` or `tests/` changed: note or run relevant tests (`cd tests && npm test` when practical).
5. [ ] If Terraform changed: roots identified; remind Frank to `terraform plan` / `apply` locally; CI plan + Checkov will run on the PR when paths match.
6. [ ] If `tests/` lockfiles changed: `npm audit --audit-level=high` must stay clean.
7. [ ] If `netrunner/` JS changed: expect CodeQL on the PR (`docs/codeql.md`); fix real findings, don’t blanket-suppress.
8. [ ] If asked for a PR: target **`staging`** unless Frank asked for a promote-to-`main` PR.
9. [ ] Docs updated when behavior or operator steps change.

## Explicit non-goals (unless Frank overrides in writing)

- SPA framework / bundler for the catalog
- Second monitoring SaaS
- CI `terraform apply` by default
- Committing credentials “temporarily”
- Reviving Play/Scala, MySQL user auth, or CodeDeploy
