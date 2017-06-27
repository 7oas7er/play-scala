package models

import com.google.inject.Inject
import models.Karte.{Alignment, Edition, Rarity}
import persist.CsvDao

import collection.JavaConverters._
import scala.util.Random

class CardCatalog @Inject()(csvDao: CsvDao) {



  val random:Random = new Random()

  lazy val allCards:CardSelection = new CardSelection(csvDao.generateCardlist().asScala.toList)

  def random(cards: List[Karte], count:Int): List[Karte] = {
    if(count > cards.length) throw new IllegalArgumentException("To few cards to randomly chose from.")
    val selectedIndices = Seq.fill(count)(Random.nextInt(cards.length))
    selectedIndices.map(x => cards(x)).toList
  }

  // Netrunner Runner Starter (v1.0): 11 vital, 30 common, 17 uncommon, 2 rare
  def starterRunner(): CardSelection = new CardSelection(random(query(Karte.Rarity.VITAL, Karte.Alignment.RUNNER, Karte.Edition.LIMITED), 11) :::
    random(query(Karte.Rarity.COMMON, Karte.Alignment.RUNNER, Karte.Edition.LIMITED), 30) :::
    random(query(Karte.Rarity.UNCOMMON, Karte.Alignment.RUNNER, Karte.Edition.LIMITED), 17) :::
    random(query(Karte.Rarity.RARE, Karte.Alignment.RUNNER, Karte.Edition.LIMITED), 2))

  // Netrunner Corporation Starter (v1.0): 11 vital, 30 common, 17 uncommon, 2 rare
  def starterCorporation(): CardSelection = new CardSelection(random(query(Karte.Rarity.VITAL, Karte.Alignment.CORPORATION, Karte.Edition.LIMITED), 11) :::
    random(query(Karte.Rarity.COMMON, Karte.Alignment.CORPORATION, Karte.Edition.LIMITED), 30) :::
    random(query(Karte.Rarity.UNCOMMON, Karte.Alignment.CORPORATION, Karte.Edition.LIMITED), 17) :::
    random(query(Karte.Rarity.RARE, Karte.Alignment.CORPORATION, Karte.Edition.LIMITED), 2))

  // Netrunner Booster (v1.0): 2 vital, 7 common, 5 uncommon, 1 rare
  def boosterLimited(): CardSelection = new CardSelection(random(query(Karte.Rarity.VITAL, null, Karte.Edition.LIMITED), 2) :::
    random(query(Karte.Rarity.COMMON, null, Karte.Edition.LIMITED), 7) :::
    random(query(Karte.Rarity.UNCOMMON, null, Karte.Edition.LIMITED), 5) :::
    random(query(Karte.Rarity.RARE, null, Karte.Edition.LIMITED), 1))

  // Proteus Booster (v2.1): 10 common, 4 uncommon, 1 rare (there are no vitals in Proteus)
  def boosterProteus(): CardSelection = new CardSelection(random(query(Karte.Rarity.COMMON, null, Karte.Edition.LIMITED), 10) :::
    random(query(Karte.Rarity.UNCOMMON, null, Karte.Edition.LIMITED), 4) :::
    random(query(Karte.Rarity.RARE, null, Karte.Edition.LIMITED), 1))

  // Classic Booster (v2.2): 6 common, 2 rare (there are only commons and rares in Classic)
  def boosterClassic(): CardSelection = new CardSelection(random(query(Karte.Rarity.COMMON, null, Karte.Edition.LIMITED), 6) :::
    random(query(Karte.Rarity.RARE, null, Karte.Edition.LIMITED), 2))

  def card(id: Int): CardSelection = {
    val cardList = allCards.cards.filter(_.id == id)
    if(cardList.isEmpty) null
    else new CardSelection(cardList)
  }

  def cards(ids: List[Int]): CardSelection = {
    new CardSelection(ids.map((id:Int) => card(id).cards.head))
  }

  def query(rarity:Rarity, alignment: Alignment, edition: Edition): List[Karte] = {
    allCards.cards.filter(alignment == null || _.alignment == alignment).filter(edition == null || _.edition == edition).filter(rarity == null || _.rarity == rarity)
  }
}
