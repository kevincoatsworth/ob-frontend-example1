package models

import play.api.libs.json.{Json, OFormat}


case class UserTelephone(value: Int)

object UserTelephone {
  implicit val formats: OFormat[UserTelephone] = Json.format[UserTelephone]
}

