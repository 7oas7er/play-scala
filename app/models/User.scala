package models


import javax.inject._

import play.api.Application
import play.api.data.Form
import play.api.data.Forms._
import play.api.db.slick.DatabaseConfigProvider
import slick.backend.DatabaseConfig
import slick.driver.JdbcProfile
import slick.driver.MySQLDriver.api._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

case class User(id: Long, firstName: String, lastName: String, email: String, password: String)

case class UserFormData(firstName: String, lastName: String, email: String, password: String)

object UnknownUser extends User(0, "unknown", "unknown", "unknown@unknown.com", "unknown")

object UserForm {

  val form = Form(
    mapping(
      "firstName" -> nonEmptyText,
      "lastName" -> nonEmptyText,
      "email" -> email,
      "password" -> nonEmptyText
    )(UserFormData.apply)(UserFormData.unapply)
  )
}

case class AuthUserFormData(email: String, password: String)

object AuthUserForm {

  val form = Form(
    mapping(
      "email" -> email,
      "password" -> nonEmptyText
    )(AuthUserFormData.apply)(AuthUserFormData.unapply)
  )
}

class UserTableDef(tag: Tag) extends Table[User](tag, "user") {

  def id = column[Long]("id", O.PrimaryKey,O.AutoInc)
  def firstName = column[String]("first_name")
  def lastName = column[String]("last_name")
  def email = column[String]("email")
  def password = column[String]("password")

  override def * =
    (id, firstName, lastName, email, password) <>(User.tupled, User.unapply)
}

@Singleton
class Users @Inject() (appProvider: Provider[Application]) {

  // This is a hack around legacy code in play-slick.
  // c.f. https://github.com/playframework/playframework/blob/2.5.4/documentation/manual/releases/release25/migration25/Migration25.md#handling-legacy-components
  def dbConfig(): DatabaseConfig[JdbcProfile] =
  DatabaseConfigProvider.get[JdbcProfile](appProvider.get())

  val users = TableQuery[UserTableDef]

  def add(user: User): Future[String] = {
    dbConfig.db.run(users += user).map(res => "User successfully added").recover {
      case ex: Exception => ex.getCause.getMessage
    }
  }

  def delete(id: Long): Future[Int] = {
    dbConfig.db.run(users.filter(_.id === id).delete)
  }

  def get(id: Long): Future[Option[User]] = {
    dbConfig.db.run(users.filter(_.id === id).result.headOption)
  }

  def listAll: Future[Seq[User]] = {
    dbConfig.db.run(users.result)
  }

  def get(email: String): Future[Option[User]] = {
    dbConfig.db.run(users.filter(_.email === email).result.headOption)
  }

}