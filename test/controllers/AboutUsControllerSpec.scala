package controllers

import org.scalatestplus.play._
import play.api.test.Helpers._
import play.api.test._

class AboutUsControllerSpec extends PlaySpec with OneAppPerTest {

  "AboutUsController GET" should {

    "render the about us page from a new instance of controller" in {
      val controller = new AboutUsController
      val home = controller.index().apply(FakeRequest())

      status(home) mustBe OK
      contentType(home) mustBe Some("text/html")
      contentAsString(home) must include ("About Us")
    }

    "render the about us page from the application" in {
      val controller = app.injector.instanceOf[AboutUsController]
      val home = controller.index().apply(FakeRequest())

      status(home) mustBe OK
      contentType(home) mustBe Some("text/html")
      contentAsString(home) must include ("About Us")
    }

    "render the about us page from the router" in {
      // Need to specify Host header to get through AllowedHostsFilter
      val request = FakeRequest(GET, "/about-us").withHeaders("Host" -> "localhost")
      val home = route(app, request).get

      status(home) mustBe OK
      contentType(home) mustBe Some("text/html")
      contentAsString(home) must include ("About Us")
    }
  }
}
