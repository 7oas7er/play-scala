#!/usr/bin/env node
/**
 * Regenerate netrunner/data/catalog.json from netrunner/data/catalog.csv.
 * Not a frontend build step — run manually (or from tests) when the CSV changes.
 */
import fs from "node:fs";
import path from "node:path";
import { fileURLToPath } from "node:url";

const root = path.resolve(path.dirname(fileURLToPath(import.meta.url)), "..");
const csvPath = path.join(root, "netrunner/data/catalog.csv");
const jsonPath = path.join(root, "netrunner/data/catalog.json");

function parseCsv(input, delim = ";") {
  const rows = [];
  let row = [];
  let field = "";
  let i = 0;
  let inQuotes = false;
  while (i < input.length) {
    const c = input[i];
    if (inQuotes) {
      if (c === '"') {
        if (input[i + 1] === '"') {
          field += '"';
          i += 2;
          continue;
        }
        inQuotes = false;
        i++;
        continue;
      }
      field += c;
      i++;
      continue;
    }
    if (c === '"') {
      inQuotes = true;
      i++;
      continue;
    }
    if (c === delim) {
      row.push(field);
      field = "";
      i++;
      continue;
    }
    if (c === "\n" || c === "\r") {
      if (c === "\r" && input[i + 1] === "\n") i++;
      row.push(field);
      field = "";
      if (row.length > 1 || row[0] !== "") rows.push(row);
      row = [];
      i++;
      continue;
    }
    field += c;
    i++;
  }
  if (field.length || row.length) {
    row.push(field);
    rows.push(row);
  }
  return rows;
}

const text = fs.readFileSync(csvPath, "utf8");
const rows = parseCsv(text);
const headers = rows[0].map((h) => h.trim());
const cards = [];
for (let r = 1; r < rows.length; r++) {
  const cols = rows[r];
  if (cols.length < headers.length) continue;
  const obj = {};
  for (let c = 0; c < headers.length; c++) {
    obj[headers[c]] = (cols[c] ?? "").trim();
  }
  const id = parseInt(obj.id, 10);
  if (!Number.isFinite(id)) continue;
  cards.push({
    id,
    cardType: obj.cardType,
    alignment: obj.alignment,
    name: obj.name,
    rarity: obj.rarity,
    text: obj.text,
    flavourText: obj.flavourText,
    illustrator: obj.illustrator,
    edition: obj.edition,
  });
}

fs.writeFileSync(jsonPath, `${JSON.stringify(cards, null, 2)}\n`);
console.log(`Wrote ${cards.length} cards to ${path.relative(root, jsonPath)}`);
