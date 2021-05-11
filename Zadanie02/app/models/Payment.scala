package models

import play.api.libs.json.Json

import java.util.Date

case class Payment(id: Long, userId: Long, paymentType: String, provider: String, accountNumber: String, expiry: Date)

object Payment {
  implicit val paymentFormat = Json.format[Payment]
}