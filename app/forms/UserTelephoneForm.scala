package forms

import models.UserTelephone
import play.api.data.Form
import play.api.data.Forms._

object UserTelephoneForm {
  def apply(): Form[UserTelephone] = {
    Form(
      mapping(
        "telephone" -> nonEmptyText)
        (UserTelephone.apply)(UserTelephone.unapply))
  }
}
