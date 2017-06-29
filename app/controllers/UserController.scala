package controllers

import javax.inject.{Inject, Singleton}

import models.{User, UserForm}
import play.api.mvc._
import services.UserService

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

@Singleton
class UserController @Inject()(userService: UserService) extends Controller {

  def register = Action.async { implicit request =>
    userService.listAllUsers map { users =>
      Ok(views.html.index("User management", views.html.body(views.html.registerTop(),views.html.noMenu(),views.html.registerContent(UserForm.form, users))))
    }
  }

  def addUser() = Action.async { implicit request =>
    UserForm.form.bindFromRequest.fold(
      // if any error in submitted data
      errorForm => {
        Future.successful(BadRequest(views.html.body(views.html.registerTop(),views.html.noMenu(),views.html.registerContent(errorForm, Seq.empty[User]))))
      },
      data => {
        val newUser = User(0, data.firstName, data.lastName, data.email)
        userService.addUser(newUser).map (res =>
        Redirect(routes.UserController.register())
        )
      })
  }

  def deleteUser(id: Long) = Action.async { implicit request =>
    userService.deleteUser(id) map { res =>
      Redirect(routes.UserController.register())
    }
  }

}