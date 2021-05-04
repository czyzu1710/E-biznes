package models
import play.api.libs.json.Json

case class ItemReview(id: Long, productId: Long)

object ItemReview {
  implicit val itemReviewFormat = Json.format[ItemReview]
}