package models

import play.api.libs.json.{Json, OFormat}

case class UserDetails(name: UserName)

object UserDetails {
  implicit val formats: OFormat[UserDetails] = Json.format[UserDetails]
}