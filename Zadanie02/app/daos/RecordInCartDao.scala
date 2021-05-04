package daos

import scala.concurrent.{ExecutionContext, Future}
import javax.inject.Inject

import models.RecordInCart
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider
import slick.jdbc.JdbcProfile

class RecordInCartDao @Inject()(protected val dbConfigProvider: DatabaseConfigProvider)(implicit executionContext: ExecutionContext) extends HasDatabaseConfigProvider[JdbcProfile] {

  import profile.api._
  import dbConfig._

  class RecordInCartTable(tag: Tag) extends Table[RecordInCart](tag, "RECORDINCART") {
    def id = column[Long]("ID", O.PrimaryKey, O.AutoInc)

    def cardId = column[Long]("CARD_ID")

    def productId = column[Long]("PRODUCT_ID")

    def quantity = column[Int]("QUANTITY")

    def * = (id, cardId, productId, quantity) <> ((RecordInCart.apply _).tupled, RecordInCart.unapply)
  }

  private val RecordsInCart = TableQuery[RecordInCartTable]

  def all(): Future[Seq[RecordInCart]] = db.run(RecordsInCart.result)

  def delete(id: Long): Future[Unit] = db.run(RecordsInCart.filter(_.id === id).delete).map(_ => ())

  def getById(id: Long): Future[RecordInCart] = db.run{
    RecordsInCart.filter(_.id === id).result.head
  }

  def update(id: Long, recordInCart: RecordInCart): Future[Unit] = db.run(RecordsInCart.filter(_.id === id).update(recordInCart)).map(_ => ())

  def insert(recordInCart: RecordInCart): Future[Unit] = db.run(RecordsInCart += recordInCart).map(_ => ())
}