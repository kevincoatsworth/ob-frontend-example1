package forms

import org.scalatestplus.play.PlaySpec

class UserEmailFormSpec extends PlaySpec {

  "UserEmailForm" should {

    "bind when all valid data is supplied" in {

    }

    "fail to bind when no data is submitted" in {

    }

    "fail to bind when no @ sign is included in the string" in {

    }

    "fail to bind when no TLD (i.e. .com, .co.uk etc) is included in the string" in {

    }

    "fail to bind when no value is passed before @ character" in {

    }

    //TODO: If you can think of any more test scenarios, add them here...
  }
}
