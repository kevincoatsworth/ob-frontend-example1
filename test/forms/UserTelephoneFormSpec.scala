package forms

import models.{UserName, UserTelephone}
import org.scalatestplus.play.PlaySpec

class UserTelephoneFormSpec extends PlaySpec {

  "UserTelephoneForm" should {

    "bind when all valid data is supplied" in {
      val form = UserTelephoneForm().bind(
        Map(
          "telephone" -> 123456
        )
      )

      form.get mustBe UserTelephone(123456)
    }

    "fail to bind when data is invalid" in {
      val form = UserTelephoneForm().bind(
        Map(
          "telephone" -> ""
        )
      )
      form.errors.head.message mustBe "error.required"
    }
  }
}
