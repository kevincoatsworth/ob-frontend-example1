package models

import play.api.libs.json.{Json, OFormat}

case class UserTelephone(value: String)

object UserTelephone {
  implicit val formats: OFormat[UserTelephone] = Json.format[UserTelephone]
}

