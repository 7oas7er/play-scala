import assert from "node:assert/strict";
import { readFileSync } from "node:fs";
import { createRequire } from "node:module";
import path from "node:path";
import { describe, it } from "node:test";
import { fileURLToPath } from "node:url";

const require = createRequire(import.meta.url);
const root = path.resolve(path.dirname(fileURLToPath(import.meta.url)), "../..");
const generators = require(path.join(root, "netrunner/js/generators.js"));
const catalog = JSON.parse(
  readFileSync(path.join(root, "netrunner/data/catalog.json"), "utf8")
);

function seededRandom(seed) {
  let s = seed >>> 0;
  return function () {
    s = (1664525 * s + 1013904223) >>> 0;
    return s / 0x100000000;
  };
}

describe("catalog data", () => {
  it("has 580 cards", () => {
    assert.equal(catalog.length, 580);
  });

  it("balances Runner and Corporation", () => {
    const runner = catalog.filter((c) => c.alignment === "Runner").length;
    const corp = catalog.filter((c) => c.alignment === "Corporation").length;
    assert.equal(runner, 290);
    assert.equal(corp, 290);
  });

  it("has Limited, Proteus, and Classic editions", () => {
    const counts = catalog.reduce((acc, c) => {
      acc[c.edition] = (acc[c.edition] || 0) + 1;
      return acc;
    }, {});
    assert.equal(counts.Limited, 374);
    assert.equal(counts.Proteus, 154);
    assert.equal(counts.Classic, 52);
  });
});

describe("generators", () => {
  const rng = seededRandom(42);

  it("builds a 60-card Runner starter from Limited Runner cards", () => {
    const pack = generators.starterRunner(catalog, rng);
    assert.equal(pack.length, 60);
    assert.ok(pack.every((c) => c.alignment === "Runner"));
    assert.ok(pack.every((c) => c.edition === "Limited"));
  });

  it("builds a 60-card Corporation starter from Limited Corp cards", () => {
    const pack = generators.starterCorporation(catalog, rng);
    assert.equal(pack.length, 60);
    assert.ok(pack.every((c) => c.alignment === "Corporation"));
    assert.ok(pack.every((c) => c.edition === "Limited"));
  });

  it("builds a 15-card Limited booster", () => {
    const pack = generators.boosterLimited(catalog, rng);
    assert.equal(pack.length, 15);
    assert.ok(pack.every((c) => c.edition === "Limited"));
  });

  it("builds a 15-card Proteus booster from Proteus edition", () => {
    const pack = generators.boosterProteus(catalog, rng);
    assert.equal(pack.length, 15);
    assert.ok(pack.every((c) => c.edition === "Proteus"));
  });

  it("builds an 8-card Classic booster from Classic edition", () => {
    const pack = generators.boosterClassic(catalog, rng);
    assert.equal(pack.length, 8);
    assert.ok(pack.every((c) => c.edition === "Classic"));
  });

  it("formats ids as a comma-separated list", () => {
    assert.equal(generators.idsOf([{ id: 1 }, { id: 2 }, { id: 10 }]), "1,2,10");
  });
});
