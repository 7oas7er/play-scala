# GitHub branch protection and security floor

Target branches: **`staging`** and **`main`**.

## Hard-required check (always runs)

| Check name | Workflow | Why |
|------------|----------|-----|
| `Required CI` | [`.github/workflows/required-ci.yml`](../.github/workflows/required-ci.yml) | Always reports on PRs to `staging`/`main`, so rulesets are not blocked by path filters |

## Path-filtered checks (enforce when they run)

These **must** pass when GitHub schedules them. Do **not** add them as ruleset-required contexts — a missing check (paths did not match) blocks merge.

| Check name | Workflow | When it runs |
|------------|----------|--------------|
| `Catalog tests` | Deploy Netrunner | `netrunner/**`, `tests/**`, or that workflow |
| `Format` | Terraform plan | `infra/terraform/**, or that workflow |
| `IaC policy (Checkov)` | Terraform plan | same as Format |
| `npm audit (tests)` | Dependency audit | `tests/package*.json` or that workflow |
| | `Analyze (javascript-typescript)` / `Analyze (actions)` | CodeQL | `netrunner/**`, workflows, or `.github/codeql/**` |

Also expect Validate / Plan jobs from Terraform plan when infra changes.

**Process:** open **high/critical** Dependabot alerts on `staging`/`main` are merge blockers — resolve or explicitly waive before promoting. Weekly Dependabot PRs already target `staging` (`.github/dependabot.yml`).

## Ruleset settings

One ruleset covering `refs/heads/staging` and `refs/heads/main` (or `~DEFAULT_BRANCH` + `refs/heads/staging`):

1. **Restrict deletions** — on  
2. **Block force pushes** — on  
3. **Require a pull request before merging** — on (0 approvals while solo; raise to 1 when a second human joins)  
4. **Require status checks to pass** — on, context **`Required CI`** only (`strict` / up-to-date optional)  

Do **not** require linear history unless you already use squash-only merges.

### Apply / update via `gh` (admin)

```bash
gh api repos/7oas7er/netrunner/rulesets --jq '.[] | {id,name,enforcement}'
gh api repos/7oas7er/netrunner/rulesets/<id>
```

Sprint 2 updates the existing `default` ruleset accordingly.

## Secret scanning

| Control | Expected |
|---------|----------|
| Secret scanning | **Enabled** |
| Push protection | **Enabled** |

(As of Sprint 2 these were already on for `7oas7er/netrunner`.)
