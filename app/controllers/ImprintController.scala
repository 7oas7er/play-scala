package controllers

import javax.inject._

import models.{Karte, CardCatalog}
import play.api.mvc._

import scala.collection.JavaConverters._

@Singleton
class ImprintController @Inject()() extends Controller {

  def getImprint()= Action {
    Ok(views.html.index("Imprint", views.html.body(views.html.imprintTop(),views.html.imprintMenu(),views.html.imprintContent())))
  }
}
