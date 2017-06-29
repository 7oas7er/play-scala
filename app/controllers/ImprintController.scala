package controllers

import javax.inject._

import play.api.mvc._

@Singleton
class ImprintController @Inject()() extends Controller {

  def getImprint()= Action {
    Ok(views.html.index("Imprint", views.html.body(views.html.imprintTop(),views.html.noMenu(),views.html.imprintContent())))
  }
}
