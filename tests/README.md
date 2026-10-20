# Netrunner tests

Unit tests (Node) and Playwright e2e for the static catalog under `netrunner/`.

```bash
cd tests
npm ci
npx playwright install --with-deps chromium   # first time
npm test
```

- `unit/` — generators, catalog helpers, card counts
- `e2e/` — smoke against `serve` on port 4173
