package models

import play.api.libs.json.Json

case class RecordInCart(id: Long, quantity: Int, productId: Long, cartId: Long)

object RecordInCart {
  implicit val recordInCartFormat = Json.format[RecordInCart]
}
