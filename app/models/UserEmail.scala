package models

import play.api.libs.json.{Json, OFormat}

case class UserEmail(value: String)

object UserEmail {
  implicit val formats: OFormat[UserEmail] = Json.format[UserEmail]
}
