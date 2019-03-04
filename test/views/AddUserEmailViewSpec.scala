package views

import forms.UserEmailForm
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import play.api.test.FakeRequest
import play.twirl.api.Html

class AddUserEmailViewSpec extends ViewSpecHelper {

  implicit val request = addToken(FakeRequest("GET", "/add-user/email"))

  class AddUserEmailPageFixture {

    lazy val html: String = view.body

    implicit lazy val doc: Document = Jsoup.parse(html)

    def view: Html = views.html.add_user_email(UserEmailForm())
  }

  "Add user email page " should {

    "contain valid content" in new AddUserEmailPageFixture {
      doc.html.contains("Add User Email") mustBe true
      doc.html.contains("Please enter your email using the field below.") mustBe true
      doc.getElementById("email").attr("name") mustBe "email"
    }

  }

}
