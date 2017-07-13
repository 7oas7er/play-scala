package services

import javax.inject._

import models.{User, Users}

import scala.concurrent.duration._
import scala.concurrent.{Await, Future}

import scala.concurrent.ExecutionContext.Implicits.global

import com.github.t3hnar.bcrypt._


@Singleton
class UserService @Inject()(users: Users) {

  def addUser(user: User): Future[String] = {
    val maybeUser = Await.result(users.get(user.email.toLowerCase), 500 millis)
    if(maybeUser.isEmpty) {
      users.add(User(0, user.firstName, user.lastName, user.email.toLowerCase, (user.password).bcrypt))
    } else {
      Future[String]("A login with the email " + user.email.toLowerCase + " has already been registered.")
    }
  }

  def deleteUser(id: Long): Future[Int] = {
    users.delete(id)
  }

  def getUser(id: Long): Future[Option[User]] = {
    users.get(id)
  }

  def listAllUsers: Future[Seq[User]] = {
    users.listAll
  }

  def getUser(email: String): Future[Option[User]] = {
    users.get(email)
  }

  def authenticate(email: String, password: String): Boolean = {
    val maybeUser = Await.result(users.get(email), 500 millis)
    maybeUser match {
      case Some(user) =>
        if(password.isBcrypted(user.password)) true
        else false
      case None => false
    }

  }

}
