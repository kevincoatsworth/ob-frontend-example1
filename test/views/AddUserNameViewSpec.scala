package views

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.scalatestplus.play.PlaySpec
import play.twirl.api.Html

class AddUserNameViewSpec extends PlaySpec{

  class AddUserNamePageFixture {

    lazy val html: String = view.body

    implicit lazy val doc: Document = Jsoup.parse(html)

    def view: Html = views.html.add_user_name()
  }

  "Add user name page " should {

    "contain valid content" in new AddUserNamePageFixture {
      doc.html.contains("Add User Name") mustBe true
      doc.html.contains("Please enter your name using the field below.") mustBe true
    }

  }
}
