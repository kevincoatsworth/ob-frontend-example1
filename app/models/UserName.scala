package models

import play.api.libs.json.{Json, OFormat}

case class UserName(value: String)

object UserName {
  implicit val formats: OFormat[UserName] = Json.format[UserName]
}
