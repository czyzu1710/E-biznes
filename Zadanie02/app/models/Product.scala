package models

import play.api.libs.json.Json

//bajo jajo - horny police

case class Product(id: Long, name: String, price: Double, description: String)

object Product {
  implicit val productFormat = Json.format[Product]
}