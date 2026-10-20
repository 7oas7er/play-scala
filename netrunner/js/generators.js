/**
 * Random starter / booster generators for classic Netrunner.
 * Draws with replacement (matches the original Play/Scala behaviour).
 */
(function (global) {
  "use strict";

  function query(cards, rarity, alignment, edition) {
    return cards.filter(function (card) {
      if (rarity != null && card.rarity !== rarity) return false;
      if (alignment != null && card.alignment !== alignment) return false;
      if (edition != null && card.edition !== edition) return false;
      return true;
    });
  }

  function randomFrom(cards, count, random) {
    if (count > cards.length) {
      throw new Error("Too few cards to randomly choose from.");
    }
    var rng = random || Math.random;
    var selected = [];
    for (var i = 0; i < count; i++) {
      var index = Math.floor(rng() * cards.length);
      selected.push(cards[index]);
    }
    return selected;
  }

  function pack(parts) {
    return parts.reduce(function (acc, part) {
      return acc.concat(part);
    }, []);
  }

  function starterRunner(cards, random) {
    return pack([
      randomFrom(query(cards, "vital", "Runner", "Limited"), 11, random),
      randomFrom(query(cards, "common", "Runner", "Limited"), 30, random),
      randomFrom(query(cards, "uncommon", "Runner", "Limited"), 17, random),
      randomFrom(query(cards, "rare", "Runner", "Limited"), 2, random),
    ]);
  }

  function starterCorporation(cards, random) {
    return pack([
      randomFrom(query(cards, "vital", "Corporation", "Limited"), 11, random),
      randomFrom(query(cards, "common", "Corporation", "Limited"), 30, random),
      randomFrom(query(cards, "uncommon", "Corporation", "Limited"), 17, random),
      randomFrom(query(cards, "rare", "Corporation", "Limited"), 2, random),
    ]);
  }

  function boosterLimited(cards, random) {
    return pack([
      randomFrom(query(cards, "vital", null, "Limited"), 2, random),
      randomFrom(query(cards, "common", null, "Limited"), 7, random),
      randomFrom(query(cards, "uncommon", null, "Limited"), 5, random),
      randomFrom(query(cards, "rare", null, "Limited"), 1, random),
    ]);
  }

  function boosterProteus(cards, random) {
    return pack([
      randomFrom(query(cards, "common", null, "Proteus"), 10, random),
      randomFrom(query(cards, "uncommon", null, "Proteus"), 4, random),
      randomFrom(query(cards, "rare", null, "Proteus"), 1, random),
    ]);
  }

  function boosterClassic(cards, random) {
    return pack([
      randomFrom(query(cards, "common", null, "Classic"), 6, random),
      randomFrom(query(cards, "rare", null, "Classic"), 2, random),
    ]);
  }

  function idsOf(cards) {
    return cards.map(function (c) {
      return String(c.id);
    }).join(",");
  }

  var api = {
    query: query,
    randomFrom: randomFrom,
    starterRunner: starterRunner,
    starterCorporation: starterCorporation,
    boosterLimited: boosterLimited,
    boosterProteus: boosterProteus,
    boosterClassic: boosterClassic,
    idsOf: idsOf,
  };

  if (typeof module !== "undefined" && module.exports) {
    module.exports = api;
  }
  global.NetrunnerGenerators = api;
})(typeof globalThis !== "undefined" ? globalThis : this);
