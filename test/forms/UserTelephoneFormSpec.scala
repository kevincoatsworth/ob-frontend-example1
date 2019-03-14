package forms

import models.UserName
import org.scalatestplus.play.PlaySpec

class UserTelephoneFormSpec extends PlaySpec {

  "UserTelephoneForm" should {

    "bind when all valid data is supplied" in {
      val form = UserTelephoneForm().bind(
        Map(
          "telephone" -> 123456
        )
      )

      form.get mustBe UserName("user telephone")
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
