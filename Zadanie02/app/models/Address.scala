
package models

import play.api.libs.json.Json

case class Address(id: Long, userId: Long, city: String, postalCode: String, country: String, telephone: String, mobile: String, addressLine: String)

object Address {
  implicit val addressFormat = Json.format[Address]
}