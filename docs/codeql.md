# CodeQL (SAST)

Workflow: [`.github/workflows/codeql.yml`](../.github/workflows/codeql.yml)  
Config: [`.github/codeql/codeql-config.yml`](../.github/codeql/codeql-config.yml)

This is **advanced setup** checked into the repo. GitHub **default** code scanning setup must stay **off** (Settings → Code security → CodeQL → default setup) so the two do not fight.

## What it covers

| Language pack | Paths |
|---------------|--------|
| `javascript-typescript` | `netrunner/**` |
| `actions` | `.github/workflows/**` |

Runs on PRs/pushes to `staging`/`main` when those paths change, plus a weekly schedule and `workflow_dispatch`. Query suite: **security-extended**.

Terraform is covered by Checkov (`docs/iac-policy.md`), not CodeQL.

Triage real findings; do not blanket-suppress. Path filters keep noise from Markdown, lockfiles, and Terraform out of the JS analysis.
