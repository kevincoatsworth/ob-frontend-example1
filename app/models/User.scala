package models

import play.api.libs.json.{Json, OFormat}

case class User(name: String)

object User {
  implicit val formats: OFormat[User] = Json.format[User]
}
