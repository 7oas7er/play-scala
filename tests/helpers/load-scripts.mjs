import fs from "node:fs";
import path from "node:path";
import vm from "node:vm";
import { fileURLToPath } from "node:url";

const repoRoot = path.resolve(path.dirname(fileURLToPath(import.meta.url)), "../..");
const jsRoot = path.join(repoRoot, "netrunner", "js");

function runScript(context, filename) {
  const code = fs.readFileSync(path.join(jsRoot, filename), "utf8");
  vm.runInContext(code, context, { filename });
}

/**
 * Load catalog + generator scripts into an isolated VM (no DOM).
 * @returns {{ NetrunnerGenerators: object, NetrunnerCatalog: object }}
 */
export function loadNetrunner() {
  const window = {};
  const context = { window, console, module: { exports: {} }, exports: {} };
  vm.createContext(context);
  runScript(context, "generators.js");
  const generators = context.NetrunnerGenerators || context.module.exports;
  context.module = { exports: {} };
  context.exports = {};
  runScript(context, "catalog.js");
  const catalog = context.NetrunnerCatalog || context.module.exports;
  return { NetrunnerGenerators: generators, NetrunnerCatalog: catalog };
}

export { repoRoot };
