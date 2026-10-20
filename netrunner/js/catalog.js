/**
 * Load catalog.json and render a sortable card table for a selection.
 */
(function (global) {
  "use strict";

  var CATALOG_URL = "data/catalog.json";

  function loadCatalog() {
    return fetch(CATALOG_URL).then(function (response) {
      if (!response.ok) {
        throw new Error("Failed to load catalog (" + response.status + ")");
      }
      return response.json();
    });
  }

  function compareValues(a, b) {
    if (typeof a === "number" && typeof b === "number") return a - b;
    return String(a).localeCompare(String(b), undefined, { sensitivity: "base" });
  }

  function sortCards(cards, key, direction) {
    var dir = direction === "desc" ? -1 : 1;
    return cards.slice().sort(function (left, right) {
      return compareValues(left[key], right[key]) * dir;
    });
  }

  function escapeHtml(value) {
    return String(value)
      .replace(/&/g, "&amp;")
      .replace(/</g, "&lt;")
      .replace(/>/g, "&gt;")
      .replace(/"/g, "&quot;");
  }

  function renderTable(tbody, cards) {
    var html = cards
      .map(function (card, index) {
        return (
          "<tr>" +
          "<td>" +
          (index + 1) +
          "</td>" +
          "<td>" +
          escapeHtml(card.id) +
          "</td>" +
          "<td>" +
          escapeHtml(card.name) +
          "</td>" +
          "<td>" +
          escapeHtml(card.alignment) +
          "</td>" +
          "<td>" +
          escapeHtml(card.cardType) +
          "</td>" +
          "<td>" +
          escapeHtml(card.text) +
          "</td>" +
          "<td>" +
          escapeHtml(card.flavourText) +
          "</td>" +
          "<td>" +
          escapeHtml(card.rarity) +
          "</td>" +
          "<td>" +
          escapeHtml(card.illustrator) +
          "</td>" +
          "<td>" +
          escapeHtml(card.edition) +
          "</td>" +
          "</tr>"
        );
      })
      .join("");
    tbody.innerHTML = html;
  }

  var api = {
    CATALOG_URL: CATALOG_URL,
    loadCatalog: loadCatalog,
    sortCards: sortCards,
    renderTable: renderTable,
    escapeHtml: escapeHtml,
  };

  if (typeof module !== "undefined" && module.exports) {
    module.exports = api;
  }
  global.NetrunnerCatalog = api;
})(typeof globalThis !== "undefined" ? globalThis : this);
