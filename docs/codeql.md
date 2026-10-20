# CodeQL

In-repo advanced CodeQL (`.github/workflows/codeql.yml`) scans:

| Language | Paths |
|----------|--------|
| `javascript-typescript` | `netrunner/**` |
| `actions` | `.github/workflows/**` |

Config: [`.github/codeql/codeql-config.yml`](../.github/codeql/codeql-config.yml). Query suite: `security-extended`.

Triage real findings; do not blanket-suppress. Path filters keep noise from Markdown, lockfiles, and Terraform out of the JS analysis.
