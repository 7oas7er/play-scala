package controllers

import javax.inject.{Inject, Singleton}

import models.{User, UserForm, AuthUserForm}
import play.api.mvc._
import services.UserService

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

@Singleton
class UserController @Inject()(userService: UserService) extends Controller {

  def login = Action { implicit request =>
    Ok(views.html.index("Login as user", views.html.body(views.html.registerTop(),views.html.noMenu(),views.html.loginContent(AuthUserForm.form))))
  }

  def register = Action { implicit request =>
    Ok(views.html.index("Register as new user", views.html.body(views.html.registerTop(),views.html.noMenu(),views.html.registerContent(UserForm.form))))
  }

  def authenticate() = Action.async { implicit request =>
    AuthUserForm.form.bindFromRequest.fold(
      // if any error in submitted data
      errorForm => {
        Future.successful(BadRequest(views.html.body(views.html.registerTop(),views.html.noMenu(),views.html.loginContent(errorForm))))
      },
      data => {
        val authUser = new User(0, "", "", data.email, data.password)
        val maybeUser = userService.authenticate(authUser)
        if(maybeUser.isDefined) {
          userService.getUser(data.email).map (res =>
            Redirect(routes.AdminController.index()))
        }
        else {
          Future.successful(Redirect(routes.UserController.login()))
        }}

    )
  }


  def addUser() = Action.async { implicit request =>
    UserForm.form.bindFromRequest.fold(
      // if any error in submitted data
      errorForm => {
        Future.successful(BadRequest(views.html.body(views.html.registerTop(),views.html.noMenu(),views.html.registerContent(errorForm))))
      },
      data => {
        val newUser = User(0, data.firstName, data.lastName, data.email, data.password)
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