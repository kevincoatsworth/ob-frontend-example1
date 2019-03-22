package views

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import play.api.test.FakeRequest
import play.twirl.api.Html

class AddUserTelephoneViewSpec extends ViewSpecHelper {

  implicit val request = addToken(FakeRequest("GET", "/add-user/telephone"))

  class AddUserTelephonePageFixture {

    lazy val html: String = view.body

    implicit lazy val doc: Document = Jsoup.parse(html)

    def view: Html = views.html.add_user_telephone()
  }

  "Add user telephone page " should {

    "contain valid content" in new AddUserTelephonePageFixture {
      doc.html.contains("Add User Telephone") mustBe true
      doc.html.contains("Please enter your telephone number using the field below.") mustBe true
      doc.getElementById("telephone").attr("name") mustBe "telephone"
    }

  }
}
