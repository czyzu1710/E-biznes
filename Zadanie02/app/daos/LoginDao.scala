package daos

import scala.concurrent.{ExecutionContext, Future}
import javax.inject.Inject
import models.Login
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider
import slick.jdbc.JdbcProfile

import java.time.LocalDateTime

class LoginDao @Inject()(protected val dbConfigProvider: DatabaseConfigProvider)(implicit executionContext: ExecutionContext) extends HasDatabaseConfigProvider[JdbcProfile] {

  import profile.api._

  class LoginTable(tag: Tag) extends Table[Login](tag, "Login") {
    def id = column[Long]("ID", O.PrimaryKey, O.AutoInc)

    def userId = column[Long]("USER_ID")

    def loginDate = column[LocalDateTime]("LOGIN_DATE")

    def * = (id, userId, loginDate) <> ((Login.apply _).tupled, Login.unapply)
  }

  private val Logins = TableQuery[LoginTable]

  def all(): Future[Seq[Login]] = db.run(Logins.result)

  def delete(id: Long): Future[Unit] = db.run(Logins.filter(_.id ===id).delete).map(_ => ())

  def getById(id: Long): Future[Login] = db.run{
    Logins.filter(_.id===id).result.head
  }

  def update(id: Long, login: Login): Future[Unit] = db.run(Logins.filter(_.id === id).update(login)).map(_ => ())

  def insert(login: Login): Future[Unit] = db.run(Logins += login).map(_ => ())
}

