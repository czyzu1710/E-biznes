package daos

import scala.concurrent.{ExecutionContext, Future}
import javax.inject.Inject

import models.ItemScore
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider
import slick.jdbc.JdbcProfile

class ItemScoreDao @Inject()(protected val dbConfigProvider: DatabaseConfigProvider)(implicit executionContext: ExecutionContext) extends HasDatabaseConfigProvider[JdbcProfile] {

  import profile.api._

  class ItemScoreTable(tag: Tag) extends Table[ItemScore](tag, "ItemScore") {
    def id = column[Long]("ID", O.PrimaryKey, O.AutoInc)

    def productId = column[Long]("PRODUCT_ID")

    def itemScore = column[Double]("ITEM_SCORE")

    def * = (id, productId, itemScore) <> ((ItemScore.apply _).tupled, ItemScore.unapply)
  }

  private val ItemScores = TableQuery[ItemScoreTable]

  def all(): Future[Seq[ItemScore]] = db.run(ItemScores.result)

  def delete(id: Long): Future[Unit] = db.run(ItemScores.filter(_.id ===id).delete).map(_ => ())

  def getById(id: Long): Future[ItemScore] = db.run{
    ItemScores.filter(_.id===id).result.head
  }

  def update(id: Long, ItemScore: ItemScore): Future[Unit] = db.run(ItemScores.filter(_.id === id).update(ItemScore)).map(_ => ())

  def insert(ItemScore: ItemScore): Future[Unit] = db.run(ItemScores += ItemScore).map(_ => ())
}
