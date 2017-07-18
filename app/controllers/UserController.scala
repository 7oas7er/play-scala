package controllers

import javax.inject.{Inject, Singleton}

import models.{User, UserForm, AuthUserForm}
import play.api.mvc._
import services.UserService

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

@Singleton
class UserController @Inject()(userService: UserService) extends Controller {

  def login(loginFailed: Option[Boolean]) = Action { implicit request =>
    Ok(views.html.user.login(AuthUserForm.form, loginFailed))
  }

  def register = Action { implicit request =>
    Ok(views.html.user.register(UserForm.form))
  }

  def authenticate = Action.async { implicit request =>
    AuthUserForm.form.bindFromRequest.fold(
      errorForm => {
        Future.successful(BadRequest(views.html.user.login(errorForm, None)).withNewSession)
      },
      data => {
        val isKnown = userService.authenticate(data.email, data.password)
        if(isKnown) {
          userService.getUser(data.email).map (res =>
            Redirect(routes.AdminController.index()).withSession(request.session + ("email" -> data.email) + ("user" -> res.getOrElse("").toString)))
        }
        else {
          Future.successful(Redirect(routes.UserController.login(Some[Boolean](true))).withNewSession)
        }}

    )
  }


  def addUser = Action.async { implicit request =>
    UserForm.form.bindFromRequest.fold(
      errorForm => {
        Future.successful(BadRequest(views.html.user.register(errorForm)))
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