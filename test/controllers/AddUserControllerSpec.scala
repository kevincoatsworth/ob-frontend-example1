package controllers

import org.scalatestplus.play._
import play.api.test._
import play.api.test.Helpers._

class AddUserControllerSpec extends PlaySpec with OneAppPerTest {

  /**
    * AddUserController SHOULD -
    * render the index page from a new instance of controller
    * render the index page from the application
    * render the index page from the router
    */
  "AddUserController GET" should {

    "render the index page from a new instance of controller" in {

      val controller = new AddUserController
      val home = controller.get().apply(FakeRequest())

      status(home) mustBe OK
      contentType(home) mustBe Some("text/html")
      contentAsString(home) must include ("Add User!")
    }

    "render the index page from the application" in {

      val controller = app.injector.instanceOf[AddUserController]
      val home = controller.get().apply(FakeRequest())

      status(home) mustBe OK
      contentType(home) mustBe Some("text/html")
      contentAsString(home) must include ("Add User!")
    }

    "render the index page from the router" in {

      val request = FakeRequest(GET, "/add-user").withHeaders("Host" -> "localhost")
      val home = route(app, request).get

      status(home) mustBe OK
      contentType(home) mustBe Some("text/html")
      contentAsString(home) must include ("Add User!")
    }
  }

}
