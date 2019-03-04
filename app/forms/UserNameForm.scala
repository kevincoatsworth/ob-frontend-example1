package forms

import models.UserName
import play.api.data.Form
import play.api.data.Forms._

object UserNameForm {
  def apply(): Form[UserName] = {
    Form(
      mapping(
        "name" -> nonEmptyText)
      (UserName.apply)(UserName.unapply))
  }
}
