import assert from "node:assert/strict";
import { createRequire } from "node:module";
import path from "node:path";
import { describe, it } from "node:test";
import { fileURLToPath } from "node:url";

const require = createRequire(import.meta.url);
const root = path.resolve(path.dirname(fileURLToPath(import.meta.url)), "../..");
const catalogApi = require(path.join(root, "netrunner/js/catalog.js"));

describe("catalog helpers", () => {
  it("sorts by numeric id", () => {
    const sorted = catalogApi.sortCards(
      [
        { id: 3, name: "c" },
        { id: 1, name: "a" },
        { id: 2, name: "b" },
      ],
      "id",
      "asc"
    );
    assert.deepEqual(
      sorted.map((c) => c.id),
      [1, 2, 3]
    );
  });

  it("sorts descending by name", () => {
    const sorted = catalogApi.sortCards(
      [
        { id: 1, name: "Alpha" },
        { id: 2, name: "Zulu" },
        { id: 3, name: "Mike" },
      ],
      "name",
      "desc"
    );
    assert.deepEqual(
      sorted.map((c) => c.name),
      ["Zulu", "Mike", "Alpha"]
    );
  });

  it("escapes HTML entities", () => {
    assert.equal(
      catalogApi.escapeHtml(`<b>"x" & y</b>`),
      "&lt;b&gt;&quot;x&quot; &amp; y&lt;/b&gt;"
    );
  });
});
