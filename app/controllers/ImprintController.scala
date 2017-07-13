package controllers

import javax.inject._

import play.api.mvc._

@Singleton
class ImprintController @Inject()() extends Controller {

  def getImprint()= Action {
    Ok(views.html.imprint.imprint())
  }
}
