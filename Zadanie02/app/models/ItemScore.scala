package models
import play.api.libs.json.Json

case class ItemScore(id: Long, productId: Long, itemScore: Double)

object ItemScore{
  implicit val itemScoreFormat = Json.format[ItemScore]
}
