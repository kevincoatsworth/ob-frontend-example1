package forms

import models.UserName
import org.scalatestplus.play.PlaySpec

class UserNameFormSpec extends PlaySpec {

  "UserNameForm" should {

    "bind when all valid data is supplied" in {
      val form = UserNameForm().bind(
        Map(
          "name" -> "user name"
        )
      )

      form.get mustBe UserName("user name")
    }

    "fail to bind when data is invalid" in {
      val form = UserNameForm().bind(
        Map(
          "name" -> ""
        )
      )
      form.errors.head.message mustBe "error.required"
    }
  }
}
