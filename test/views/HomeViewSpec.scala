package views

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.scalatestplus.play.PlaySpec
import play.twirl.api.Html

class HomeViewSpec extends PlaySpec {

  class HomePageFixture {

    lazy val html: String = view.body

    implicit lazy val doc: Document = Jsoup.parse(html)

    def view: Html = views.html.index()
  }

  "Home page" should {

    "contain valid content" in new HomePageFixture {
      doc.html.contains("This website provides a simple example of a service built in Scala following a TTD approach.") mustBe true
      doc.html.contains("You can view the source code on ") mustBe true
      doc.getElementById("git-link").attr("href") mustBe "https://github.com/chris-ianson/ob-frontend-example1"
      doc.html.contains("over on github.com") mustBe true
    }

  }

}
