package models
import play.api.libs.json.Json

import java.time.LocalDateTime

case class Login(id: Long, userId: Long, loginDate: LocalDateTime)

object Login{
  implicit val loginFormat = Json.format[Login]
}
