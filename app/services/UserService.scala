package services

import javax.inject._

import models.{User, Users}

import scala.concurrent.duration._
import scala.concurrent.{Await, Future}

import com.github.t3hnar.bcrypt._


@Singleton
class UserService @Inject()(users: Users) {

  def addUser(user: User): Future[String] = {
    val dbuser = User(0, user.firstName, user.lastName, user.email, (user.password).bcrypt)
    users.add(dbuser)
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
