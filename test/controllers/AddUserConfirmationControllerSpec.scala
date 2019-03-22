package controllers

import org.scalatestplus.play._
import play.api.test.Helpers._
import play.api.test._

class AddUserConfirmationControllerSpec extends PlaySpec with OneAppPerTest {

  "HomeController GET" should {

    "render the index page from a new instance of controller" in {
      val controller = new AddUserConfirmationController
      val request = controller.get().apply(FakeRequest())

      status(request) mustBe OK
      contentType(request) mustBe Some("text/html")
    }

    "render the index page from the application" in {
      val controller = app.injector.instanceOf[AddUserConfirmationController]
      val request = controller.get().apply(FakeRequest())

      status(request) mustBe OK
      contentType(request) mustBe Some("text/html")
    }

    "render the index page from the router" in {
      val requestF = FakeRequest(GET, "/add-user/confirmation").withHeaders("Host" -> "localhost")
      val request = route(app, requestF).get

      status(request) mustBe OK
      contentType(request) mustBe Some("text/html")
      contentAsString(request) must include ("Name: not set")
    }
  }
}
