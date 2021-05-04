package daos

import scala.concurrent.{ExecutionContext, Future}
import javax.inject.Inject

import models.ItemReview
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider
import slick.jdbc.JdbcProfile

class ItemReviewDao @Inject()(protected val dbConfigProvider: DatabaseConfigProvider)(implicit executionContext: ExecutionContext) extends HasDatabaseConfigProvider[JdbcProfile] {

  import profile.api._

  class ItemReviewTable(tag: Tag) extends Table[ItemReview](tag, "ITEM_REVIEW") {
    def id = column[Long]("ID", O.PrimaryKey, O.AutoInc)

    def productId = column[Long]("PRODUCT_ID")

    def * = (id, productId) <> ((ItemReview.apply _).tupled, ItemReview.unapply)
  }

  private val ItemReviews = TableQuery[ItemReviewTable]

  def all(): Future[Seq[ItemReview]] = db.run(ItemReviews.result)

  def delete(id: Long): Future[Unit] = db.run(ItemReviews.filter(_.id ===id).delete).map(_ => ())

  def getById(id: Long): Future[ItemReview] = db.run{
    ItemReviews.filter(_.id===id).result.head
  }

  def update(id: Long, itemReview: ItemReview): Future[Unit] = db.run(ItemReviews.filter(_.id === id).update(itemReview)).map(_ => ())

  def insert(itemReview: ItemReview): Future[Unit] = db.run(ItemReviews += itemReview).map(_ => ())
}

