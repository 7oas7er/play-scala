package services

import javax.inject._

import models.{User, Users}

import scala.concurrent.duration._
import scala.concurrent.{Await, Future}


@Singleton
class UserService @Inject()(users: Users) {

  def addUser(user: User): Future[String] = {
    users.add(user)
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
        if(user.password == password) true
        else false
      case None => false
    }

  }

}
