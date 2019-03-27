package forms

import models.UserEmail
import play.api.data.{Form, Mapping}
import play.api.data.Forms._
import play.api.data.validation._
import play.api.data.format.Formats._

object UserEmailForm {

  private val emailRegex = """(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|"(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])*")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\])""".r

  def apply(): Form[UserEmail] = {
    Form(
      mapping(
        "email" -> emailAddress)
      (UserEmail.apply)(UserEmail.unapply))
  }

  private def emailAddressConstraint: Constraint[String] = Constraint[String]("constraint.email") { e =>
    if (e.trim.isEmpty) {
      Invalid(ValidationError("error.email"))
    }
    else {
      emailRegex.findFirstMatchIn(e)
        .map(_ => Valid)
        .getOrElse(Invalid(ValidationError("error.email")))
    }
  }

  private val emailAddress: Mapping[String] = of[String] verifying emailAddressConstraint
}
