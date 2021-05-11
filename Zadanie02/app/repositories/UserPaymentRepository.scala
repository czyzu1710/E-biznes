package repositories

import models.Payment
import play.api.db.slick.DatabaseConfigProvider
import slick.driver.JdbcProfile

import java.util.Date
import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class PaymentRepository @Inject()(dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext) {
  val dbConfig = dbConfigProvider.get[JdbcProfile]

  import dbConfig._
  import profile.api._

  implicit val JavaUtilDateMapper =
    MappedColumnType .base[java.util.Date, java.sql.Timestamp] (
      d => new java.sql.Timestamp(d.getTime),
      d => new java.util.Date(d.getTime))

  class  PaymentTable(tag: Tag) extends Table[Payment](tag, "payment") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def userId = column[Long]("userId")
    def paymentType = column[String]("paymentType")
    def provider = column[String]("provider")
    def accountNumber = column[String]("accountNumber")
    def expiry = column[Date]("expiry")
    def * = (id, userId, paymentType, provider, accountNumber, expiry) <> ((Payment.apply _).tupled, Payment.unapply)
  }

  val userPay = TableQuery[PaymentTable]

  def list(): Future[Seq[Payment]] = db.run {
    userPay.result
  }

  def delete(id: Long): Future[Unit] = db.run(userPay.filter(_.id === id).delete).map(_ => ())
  def deleteJson(id: Long): Future[Int] = db.run(userPay.filter(_.id === id).delete)

  def getById(id: Long): Future[Payment] = db.run {
    userPay.filter(_.id === id).result.head
  }

  def update(id: Long, newElement: Payment): Future[Unit] = {
    val toUpdate: Payment = newElement.copy(id)
    db.run(userPay.filter(_.id === id).update(toUpdate)).map(_ => ())
  }
  def updateJson(id: Long, newElement: Payment): Future[Int] = {
    val toUpdate: Payment = newElement.copy(id)
    db.run(userPay.filter(_.id === id).update(toUpdate))
  }

  def create(userId: Long, paymentType: String, provider: String, accountNumber: String, expiry: Date): Future[Payment] = db.run {
    (userPay.map(el => (el.userId, el.paymentType, el.provider, el.accountNumber, el.expiry))
      returning userPay.map(_.id)
      into {case ((userId, paymentType, provider, accountNumber, expiry),id) => Payment(id, userId, paymentType, provider, accountNumber, expiry)}
      ) += (userId, paymentType, provider, accountNumber, expiry)
  }
}
