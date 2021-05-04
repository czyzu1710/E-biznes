package models
import play.api.libs.json.Json


case class RecordInCart(id: Long, cardId: Long, productId: Long, quantity: Int)

object RecordInCart {
  implicit val recordInCartFormat = Json.format[RecordInCart]
}