package views

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.scalatestplus.play.PlaySpec
import play.twirl.api.Html

class AddUserViewSpec extends PlaySpec {

  class AddUserPageFixture {

    lazy val html: String = view.body

    implicit lazy val doc: Document = Jsoup.parse(html)

    def view: Html = views.html.add_user()
  }

  "Add User page" should {

    "contain valid content" in new AddUserPageFixture {
      doc.html.contains("Add User!") mustBe true
      doc.html.contains("Please follow the link below to add a new user:") mustBe true
      doc.getElementById("add-user-link").attr("href") mustBe "/add-user/name"
      doc.html.contains("Add New User")
    }
  }
}
