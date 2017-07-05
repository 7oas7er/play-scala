package controllers

import javax.inject.{Inject, Singleton}

import play.api.mvc.{Action, Controller}
import services.UserService

import scala.concurrent.ExecutionContext.Implicits.global

@Singleton
class AdminController @Inject()(userService: UserService) extends Controller {

  def index = Action.async { implicit request =>
    userService.listAllUsers map {
      users => Ok(views.html.index("Admin", views.html.body(views.html.adminTop(),views.html.noMenu(),views.html.adminContent(users))))
    }

  }

}
