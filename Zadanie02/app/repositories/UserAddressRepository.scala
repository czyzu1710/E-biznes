package repositories

import models.Address
import play.api.db.slick.DatabaseConfigProvider
import slick.driver.JdbcProfile

import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class AddressRepository @Inject()(dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext) {
  val dbConfig = dbConfigProvider.get[JdbcProfile]

  import dbConfig._
  import profile.api._

  class  AddressTable(tag: Tag) extends Table[Address](tag, "address") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def userId = column[Long]("userId")
    def city = column[String]("city")
    def postalCode = column[String]("postalCode")
    def country = column[String]("country")
    def telephone = column[String]("telephone")
    def mobile = column[String]("mobile")
    def addressLine = column[String]("addressLine")

    def * = (id, userId, city, postalCode, country, telephone, mobile, addressLine) <> ((Address.apply _).tupled, Address.unapply)
  }

  val userAdd = TableQuery[AddressTable]

  def list(): Future[Seq[Address]] = db.run {
    userAdd.result
  }

  def delete(id: Long): Future[Unit] = db.run(userAdd.filter(_.id === id).delete).map(_ => ())
  def deleteJson(id: Long): Future[Int] = db.run(userAdd.filter(_.id === id).delete)

  def getById(id: Long): Future[Address] = db.run {
    userAdd.filter(_.id === id).result.head
  }

  def update(id: Long, newElement: Address): Future[Unit] = {
    val toUpdate: Address = newElement.copy(id)
    db.run(userAdd.filter(_.id === id).update(toUpdate)).map(_ => ())
  }
  def updateJson(id: Long, newElement: Address): Future[Int] = {
    val toUpdate: Address = newElement.copy(id)
    db.run(userAdd.filter(_.id === id).update(toUpdate))
  }

  def create(userId: Long, city: String, postalCode: String, country: String, telephone: String, mobile: String, addressLine: String): Future[Address] = db.run {
    (userAdd.map(el => (el.userId, el.city, el.postalCode, el.country, el.telephone, el.mobile, el.addressLine))
      returning userAdd.map(_.id)
      into {case ((userId, city, postalCode, country, telephone, mobile, addressLine),id) => Address(id, userId, city, postalCode, country, telephone, mobile, addressLine)}
      ) += (userId, city, postalCode, country, telephone, mobile, addressLine)
  }
}
