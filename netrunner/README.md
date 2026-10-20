# Netrunner (static catalog)

Classic Netrunner card browser: full catalog, random Runner/Corp starters, and Limited / Proteus / Classic boosters.

## Local

Serve the folder (required for `fetch` of `data/catalog.json`):

```bash
npx --yes serve netrunner -l 4173
```

Open http://localhost:4173 — use the nav or `?view=starter-runner` (and similar) query params.

## Data

- Editable source: [`data/catalog.csv`](data/catalog.csv) (semicolon-separated)
- Runtime file: [`data/catalog.json`](data/catalog.json)

Regenerate JSON after CSV edits:

```bash
node scripts/csv-to-catalog-json.mjs
```

## Scripts

| File | Role |
|------|------|
| `js/generators.js` | Starter/booster rarity mixes (unit-tested) |
| `js/catalog.js` | Load + sort + table render helpers |
| `js/main.js` | UI wiring |

Random draws allow duplicates (same as the original Play/Scala app).
