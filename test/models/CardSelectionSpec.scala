package models

import org.scalatest.{FlatSpec, Matchers}

class CardSelectionSpec extends FlatSpec with Matchers {

  "new CardSelection of 77 and 815" should "generate valid id 77,815" in {
    val karte1:Karte = new Karte()
    karte1.id = 77
    val karte2:Karte = new Karte()
    karte2.id = 815
    val cardList:List[Karte] = List[Karte](karte1,karte2)

    new CardSelection(cardList).ids shouldBe "77,815"

  }

  "new CardSelection of null" should "throw IllegalArgumentException" in {
    assertThrows[IllegalArgumentException] {
      new CardSelection(null)
    }

  }

}
