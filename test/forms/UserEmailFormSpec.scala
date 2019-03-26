package forms

import org.scalatestplus.play.PlaySpec

class UserEmailFormSpec extends PlaySpec {

  "UserEmailForm" should {

    "bind when all valid data is supplied" in {
      val form = UserEmailForm().bind(
        Map(
          "email" -> "bta4life@hmrc.gov.uk"
        )
      )
    }

    "fail to bind when no data is submitted" in {
      val form = UserEmailForm().bind(
        Map(
          "email" -> ""
        )
      )
      form.errors.head.message mustBe "error.email"
    }

    "fail to bind when no @ sign is included in the string" in {
      val form = UserEmailForm().bind(
        Map(
          "email" -> "bta4lifehmrc.gov.uk"
        )
      )
      form.errors.head.message mustBe "error.email"
    }

    "fail to bind when no TLD (i.e. .com, .co.uk etc) is included in the string" in {
      val form = UserEmailForm().bind(
        Map(
          "email" -> "bta4life@hmrc"
        )
      )
      form.errors.head.message mustBe "error.email"

    }

    "fail to bind when no value is passed before @ character" in {
      val form = UserEmailForm().bind(
        Map(
          "email" -> "@hmrc.gov.uk"
        )
      )
      form.errors.head.message mustBe "error.email"
    }

    //TODO: If you can think of any more test scenarios, add them here...
  }
}
