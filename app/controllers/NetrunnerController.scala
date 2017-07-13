package controllers

import javax.inject._

import models.CardCatalog
import play.api.mvc._

@Singleton
class NetrunnerController @Inject() (catalog:CardCatalog) extends Controller {

  def cards = Action {
    Ok(views.html.netrunner.netrunner(catalog.allCards))
  }

  def starterRunner = Action {
    Ok(views.html.netrunner.netrunner(catalog.starterRunner))
  }

  def starterCorporation()= Action {
    Ok(views.html.netrunner.netrunner(catalog.starterCorporation))
  }

  def boosterLimited()= Action {
    Ok(views.html.netrunner.netrunner(catalog.boosterLimited))
  }

  def boosterProteus()= Action {
    Ok(views.html.netrunner.netrunner(catalog.boosterProteus))
  }

  def boosterClassic()= Action {
    Ok(views.html.netrunner.netrunner(catalog.boosterClassic))
  }

}
