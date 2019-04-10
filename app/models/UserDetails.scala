package models

import play.api.libs.json.{Json, OFormat}

case class UserDetails(name: UserName, telephone: UserTelephone, email: UserEmail)

object UserDetails {
  implicit val formats: OFormat[UserDetails] = Json.format[UserDetails]
}