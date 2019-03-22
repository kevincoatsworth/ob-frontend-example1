package views

import forms.UserNameForm
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import play.api.test.FakeRequest
import play.twirl.api.Html

class AddUserNameViewSpec extends ViewSpecHelper {

  implicit val request = addToken(FakeRequest("GET", "/add-user/name"))

  class AddUserNamePageFixture {

    lazy val html: String = view.body

    implicit lazy val doc: Document = Jsoup.parse(html)

    def view: Html = views.html.add_user_name(UserNameForm())
  }

  "Add user name page " should {

    "contain valid content" in new AddUserNamePageFixture {
      doc.html.contains("Add User Name") mustBe true
      doc.html.contains("Please enter your name using the field below.") mustBe true
      doc.getElementById("name").attr("name") mustBe "name"
    }

  }
}
