(function () {
  "use strict";

  var MODE_LABELS = {
    all: "All Cards",
    "starter-runner": "Runner Starter",
    "starter-corporation": "Corp Starter",
    "booster-limited": "Limited Booster",
    "booster-proteus": "Proteus Booster",
    "booster-classic": "Classic Booster",
  };

  var MODE_COUNTS = {
    all: null,
    "starter-runner": 60,
    "starter-corporation": 60,
    "booster-limited": 15,
    "booster-proteus": 15,
    "booster-classic": 8,
  };

  var state = {
    catalog: [],
    selection: [],
    mode: "all",
    sortKey: "id",
    sortDir: "asc",
  };

  function modeFromLocation() {
    var params = new URLSearchParams(window.location.search);
    var mode = params.get("view") || "all";
    return Object.prototype.hasOwnProperty.call(MODE_LABELS, mode) ? mode : "all";
  }

  function selectCards(mode, catalog) {
    var g = window.NetrunnerGenerators;
    switch (mode) {
      case "starter-runner":
        return g.starterRunner(catalog);
      case "starter-corporation":
        return g.starterCorporation(catalog);
      case "booster-limited":
        return g.boosterLimited(catalog);
      case "booster-proteus":
        return g.boosterProteus(catalog);
      case "booster-classic":
        return g.boosterClassic(catalog);
      default:
        return catalog.slice();
    }
  }

  function setActiveNav(mode) {
    document.querySelectorAll("[data-view]").forEach(function (link) {
      var active = link.getAttribute("data-view") === mode;
      link.classList.toggle("is-active", active);
      if (active) link.setAttribute("aria-current", "page");
      else link.removeAttribute("aria-current");
    });
  }

  function updateMeta() {
    var title = document.getElementById("view-title");
    var count = document.getElementById("view-count");
    var idsBlock = document.getElementById("selection-ids");
    var idsText = document.getElementById("ids-text");
    var regen = document.getElementById("regen");
    title.textContent = MODE_LABELS[state.mode];
    count.textContent = String(state.selection.length);
    if (state.mode === "all") {
      idsBlock.hidden = true;
      idsText.textContent = "";
      regen.hidden = true;
    } else {
      idsBlock.hidden = false;
      idsText.textContent = window.NetrunnerGenerators.idsOf(state.selection);
      regen.hidden = false;
    }
  }

  function paint() {
    var sorted = window.NetrunnerCatalog.sortCards(
      state.selection,
      state.sortKey,
      state.sortDir
    );
    window.NetrunnerCatalog.renderTable(
      document.querySelector("#cards-table tbody"),
      sorted
    );
    updateMeta();
    setActiveNav(state.mode);
    document.querySelectorAll("#cards-table th[data-sort]").forEach(function (th) {
      var key = th.getAttribute("data-sort");
      th.classList.toggle("is-sorted", key === state.sortKey);
      th.setAttribute(
        "aria-sort",
        key === state.sortKey
          ? state.sortDir === "asc"
            ? "ascending"
            : "descending"
          : "none"
      );
    });
  }

  function applyMode(mode, regenerate) {
    state.mode = mode;
    if (regenerate || state.mode === "all" || state.selection.length === 0) {
      state.selection = selectCards(mode, state.catalog);
    }
    var url = new URL(window.location.href);
    if (mode === "all") url.searchParams.delete("view");
    else url.searchParams.set("view", mode);
    window.history.replaceState({}, "", url);
    paint();
  }

  function bindSorting() {
    document.querySelector("#cards-table thead").addEventListener("click", function (event) {
      var th = event.target.closest("th[data-sort]");
      if (!th) return;
      var key = th.getAttribute("data-sort");
      if (state.sortKey === key) {
        state.sortDir = state.sortDir === "asc" ? "desc" : "asc";
      } else {
        state.sortKey = key;
        state.sortDir = "asc";
      }
      paint();
    });
  }

  function bindRegen() {
    var button = document.getElementById("regen");
    button.addEventListener("click", function () {
      if (state.mode === "all") return;
      applyMode(state.mode, true);
    });
  }

  function showError(message) {
    var el = document.getElementById("status");
    el.hidden = false;
    el.textContent = message;
  }

  window.NetrunnerCatalog.loadCatalog()
    .then(function (cards) {
      state.catalog = cards;
      bindSorting();
      bindRegen();
      applyMode(modeFromLocation(), true);
      var expected = MODE_COUNTS[state.mode];
      if (expected != null && state.selection.length !== expected) {
        showError("Unexpected pack size: " + state.selection.length);
      }
    })
    .catch(function (err) {
      showError(err.message || "Could not load catalog.");
    });
})();
