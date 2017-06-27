package controllers

import javax.inject._

import models.{CardCatalog, CardSelection, Karte}
import play.api.libs.json._
import play.api.mvc._

@Singleton
class NetrunnerRestController @Inject()(katalog:CardCatalog) extends Controller {

  implicit val karteWrites = new Writes[Karte] {
    override def writes(k: Karte) = Json.obj(
      "id" -> k.id,
      "name" -> k.name,
      "alignment" -> k.alignment.toString,
      "type" -> k.cardType.toString,
      "text" -> k.text,
      "flavourText" -> k.flavourText,
      "rarity" -> k.rarity.toString,
      "illustrator" -> k.illustrator,
      "edition" -> k.edition.toString
    )
  }

  implicit val cardSelectionWrites = new Writes[CardSelection] {
    override def writes(cs: CardSelection) = Json.obj(
      "cards" -> Json.toJson(cs.cards),
      "ids" -> cs.ids
    )
  }

  def starterRunner = Action { implicit request =>
    Ok(Json.toJson(katalog.starterRunner))
  }

  def starterCorporation()= Action { implicit request =>
    Ok(Json.toJson(katalog.starterCorporation))
  }

  def boosterLimited()= Action { implicit request =>
    Ok(Json.toJson(katalog.boosterLimited))
  }

  def boosterProteus()= Action { implicit request =>
    Ok(Json.toJson(katalog.boosterProteus))
  }

  def boosterClassic() = Action { implicit request =>
    Ok(Json.toJson(katalog.boosterClassic))
  }

  def card(id: Int) = Action { implicit request =>
    if (katalog.card(id) == null) NotFound
    else Ok(Json.toJson(katalog.card(id)))
  }

  def allCards() = Action { implicit request =>
    Ok(Json.toJson(katalog.allCards))
  }

  def cards(ids: String) = Action {
    implicit request =>
    def idList = ids.split(",").toList.map((s: String) => s.toInt)
    Ok(Json.toJson(katalog.cards(idList)))
  }
}
