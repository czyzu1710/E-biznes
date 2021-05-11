package repositories

import models.RecordInCart
import play.api.db.slick.DatabaseConfigProvider
import slick.driver.JdbcProfile

import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class RecordInCartRepository @Inject()(dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext) {
  val dbConfig = dbConfigProvider.get[JdbcProfile]

  import dbConfig._
  import profile.api._

  class RecordInCartTable(tag: Tag) extends Table[RecordInCart](tag, "recordInCart") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def quantity = column[Int]("quantity")
    def productId = column[Long]("productId")
    def cartId = column[Long]("cartId")
    def * = (id, quantity, productId, cartId) <> ((RecordInCart.apply _).tupled, RecordInCart.unapply)
  }

  val recordInCart = TableQuery[RecordInCartTable]

  def list(): Future[Seq[RecordInCart]] = db.run {
    recordInCart.result
  }

  def delete(id: Long): Future[Unit] = db.run(recordInCart.filter(_.id === id).delete).map(_ => ())
  def deleteJson(id: Long): Future[Int] = db.run(recordInCart.filter(_.id === id).delete)

  def getById(id: Long): Future[RecordInCart] = db.run {
    recordInCart.filter(_.id === id).result.head
  }

  def update(id: Long, newElement: RecordInCart): Future[Unit] = {
    val toUpdate: RecordInCart = newElement.copy(id)
    db.run(recordInCart.filter(_.id === id).update(toUpdate)).map(_ => ())
  }
  def updateJson(id: Long, newElement: RecordInCart): Future[Int] = {
    val toUpdate: RecordInCart = newElement.copy(id)
    db.run(recordInCart.filter(_.id === id).update(toUpdate))
  }

  def create(quantity: Int, productId: Long, cartId: Long): Future[RecordInCart] = db.run {
    (recordInCart.map(el => (el.quantity, el.productId, el.cartId))
      returning recordInCart.map(_.id)
      into {case ((quantity, productId, cartId),id) => RecordInCart(id, quantity, productId, cartId)}
      ) += (quantity, productId, cartId)
  }
}
