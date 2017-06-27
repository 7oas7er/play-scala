package controllers

import javax.inject._

import models.{Karte, CardCatalog}
import play.api.mvc._

@Singleton
class NetrunnerController @Inject() (catalog:CardCatalog) extends Controller {

  val title = "7oas7er's Netrunner Page"

  def cards = Action {
    Ok(views.html.index(title, views.html.body(views.html.nrtop(),views.html.nrmenu(),views.html.nrcontent(catalog.allCards))))
  }

  def starterRunner = Action {
    Ok(views.html.index(title, views.html.body(views.html.nrtop(),views.html.nrmenu(),views.html.nrcontent(catalog.starterRunner))))
  }

  def starterCorporation()= Action {
    Ok(views.html.index(title, views.html.body(views.html.nrtop(),views.html.nrmenu(),views.html.nrcontent(catalog.starterCorporation))))
  }

  def boosterLimited()= Action {
    Ok(views.html.index(title, views.html.body(views.html.nrtop(),views.html.nrmenu(),views.html.nrcontent(catalog.boosterLimited))))
  }

  def boosterProteus()= Action {
    Ok(views.html.index(title, views.html.body(views.html.nrtop(),views.html.nrmenu(),views.html.nrcontent(catalog.boosterProteus))))
  }

  def boosterClassic()= Action {
    Ok(views.html.index(title, views.html.body(views.html.nrtop(),views.html.nrmenu(),views.html.nrcontent(catalog.boosterClassic))))
  }

}
