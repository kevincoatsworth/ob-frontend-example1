package views

import models.{UserDetails, UserEmail, UserName, UserTelephone}
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.scalatestplus.play.PlaySpec
import play.twirl.api.Html

class AddUserConfirmationViewSpec extends PlaySpec {

  class AddUserConfirmationFixture {

    lazy val html: String = view.body

    implicit lazy val doc: Document = Jsoup.parse(html)

    val userDetails = UserDetails(name = UserName("Tony"), telephone = UserTelephone("123456"), email = UserEmail("tony@bta4life.com"))

    def view: Html = views.html.add_user_confirmation(userDetails)
  }

  "Add user confirmation page" should {

    "contain valid content" in new AddUserConfirmationFixture {
      doc.getElementsByTag("h1").first().text mustBe "Confirm User Details"
      doc.html.contains("Please confirm the user details below are correct before you submit the form.") mustBe true
      doc.html.contains("Name: Tony") mustBe true
      doc.html.contains("Telephone: 123456") mustBe true
      doc.html.contains("Email: tony@bta4life.com") mustBe true
    }

  }

}
