package models

import org.scalatest._
import persist.CsvDao

class CardCatalogSpec extends FlatSpec with Matchers {

  val cardKatalog = new CardCatalog(new CsvDao)

  "All cards" should "be 580 in total" in {
    cardKatalog.allCards.cards.size shouldBe 580
  }

  "queryCards" should "find 580 cards in total" in {
    cardKatalog.query(null, null, null).length shouldBe 580
  }

  "queryCards" should "find 290 Runner cards" in {
    cardKatalog.query(null,Karte.Alignment.RUNNER, null).length shouldBe 290
  }

  "queryCards" should "find 290 Corporation cards" in {
    cardKatalog.query(null,Karte.Alignment.CORPORATION, null).length shouldBe 290
  }

  "queryCards" should "find 180 rare cards" in {
    cardKatalog.query(Karte.Rarity.RARE,null, null).length shouldBe 180
  }

  "queryCards" should "find 44 vital cards" in {
    cardKatalog.query(Karte.Rarity.VITAL,null, null).length shouldBe 44
  }

  "queryCards" should "find 374 Limited cards" in {
    cardKatalog.query(null,null, Karte.Edition.LIMITED).length shouldBe 374
  }

  "queryCards" should "find 154 Proteus cards" in {
    cardKatalog.query(null,null, Karte.Edition.PROTEUS).length shouldBe 154
  }

  "generateLimitedStartedRunner" should "have 60 cards" in {
    cardKatalog.starterRunner().cards.length shouldBe 60
  }

  "generateLimitedStartedCorporation" should "have 60 cards" in {
    cardKatalog.starterCorporation().cards.length shouldBe 60
  }

  "generateLimitedBooster" should "have 15 cards" in {
    cardKatalog.boosterLimited().cards.length shouldBe 15
  }

  "generateProteusBooster" should "have 15 cards" in {
    cardKatalog.boosterProteus().cards.length shouldBe 15
  }

  "generateClassicBooster" should "have 8 cards" in {
    cardKatalog.boosterClassic().cards.length shouldBe 8
  }
}
