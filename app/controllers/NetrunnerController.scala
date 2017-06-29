package controllers

import javax.inject._

import models.CardCatalog
import play.api.mvc._

@Singleton
class NetrunnerController @Inject() (catalog:CardCatalog) extends Controller {

  val title = "7oas7er's Netrunner Page"

  def cards = Action {
    Ok(views.html.index(title, views.html.body(views.html.nrTop(),views.html.nrMenu(),views.html.nrContent(catalog.allCards))))
  }

  def starterRunner = Action {
    Ok(views.html.index(title, views.html.body(views.html.nrTop(),views.html.nrMenu(),views.html.nrContent(catalog.starterRunner))))
  }

  def starterCorporation()= Action {
    Ok(views.html.index(title, views.html.body(views.html.nrTop(),views.html.nrMenu(),views.html.nrContent(catalog.starterCorporation))))
  }

  def boosterLimited()= Action {
    Ok(views.html.index(title, views.html.body(views.html.nrTop(),views.html.nrMenu(),views.html.nrContent(catalog.boosterLimited))))
  }

  def boosterProteus()= Action {
    Ok(views.html.index(title, views.html.body(views.html.nrTop(),views.html.nrMenu(),views.html.nrContent(catalog.boosterProteus))))
  }

  def boosterClassic()= Action {
    Ok(views.html.index(title, views.html.body(views.html.nrTop(),views.html.nrMenu(),views.html.nrContent(catalog.boosterClassic))))
  }

}
