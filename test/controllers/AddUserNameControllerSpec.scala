package controllers

import org.scalatestplus.play.{OneAppPerSuite, PlaySpec}
import play.api.test.FakeRequest
import play.api.test.Helpers._

class AddUserNameControllerSpec extends PlaySpec with OneAppPerSuite {
  "AddUserNameController GET" should {

    "render the page from a new instance of controller" in {
      val controller = new AddUserNameController
      val home = controller.get().apply(FakeRequest())

      status(home) mustBe OK
      contentType(home) mustBe Some("text/html")
    }

    "render the page from the application" in {
      val controller = app.injector.instanceOf[AddUserNameController]
      val home = controller.get().apply(FakeRequest())

      status(home) mustBe OK
      contentType(home) mustBe Some("text/html")
    }

    "render the page from the router" in {
      val request = FakeRequest(GET, "/add-user/name").withHeaders("Host" -> "localhost")
      val home = route(app, request).get

      status(home) mustBe OK
      contentType(home) mustBe Some("text/html")
    }
  }
}
