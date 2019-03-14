package controllers

import org.scalatestplus.play.{OneAppPerSuite, PlaySpec}
import play.api.i18n.MessagesApi
import play.api.inject.Injector
import play.api.libs.json.Json
import play.api.test.FakeRequest
import play.api.test.Helpers._

class AddUserNameControllerSpec extends PlaySpec with OneAppPerSuite {

  def injector: Injector = app.injector

  def messagesApi: MessagesApi = injector.instanceOf[MessagesApi]

  "AddUserNameController" when {

    "GET is called" should {

      "render the page from a new instance of controller" in {
        val controller = new AddUserNameController(messagesApi)
        val csrfAddToken = app.injector.instanceOf[play.filters.csrf.CSRFAddToken]
        val action = csrfAddToken(controller.get())
        val request = action(FakeRequest())

        status(request) mustBe OK
        contentType(request) mustBe Some("text/html")
      }

      "render the page from the application" in {
        val controller = app.injector.instanceOf[AddUserNameController]
        val csrfAddToken = app.injector.instanceOf[play.filters.csrf.CSRFAddToken]
        val action = csrfAddToken(controller.get())
        val request = action(FakeRequest())

        status(request) mustBe OK
        contentType(request) mustBe Some("text/html")
      }

      "render the page from the router" in {
        val request = FakeRequest(GET, "/add-user/name").withHeaders("Host" -> "localhost")
        val home = route(app, request).get

        status(home) mustBe OK
        contentType(home) mustBe Some("text/html")
      }

    }

    "POST is called" should {

      "accept a post request and return no products" in {
        val controller = new AddUserNameController(messagesApi)
        val csrfAddToken = app.injector.instanceOf[play.filters.csrf.CSRFAddToken]
        val action = csrfAddToken(controller.post())
        val request = action(FakeRequest().withJsonBody(Json.obj("name" -> "test")))
        status(request) mustBe 200
        contentType(request) mustBe Some("text/html")
      }

      "accept a post request and return 400 if data is invalid" in {
        val controller = new AddUserNameController(messagesApi)
        val csrfAddToken = app.injector.instanceOf[play.filters.csrf.CSRFAddToken]
        val action = csrfAddToken(controller.post())
        val request = action(FakeRequest().withJsonBody(Json.obj("name" -> "")))
        status(request) mustBe 400
        contentType(request) mustBe Some("text/html")
        contentAsString(request) must include("This field is required")
      }

    }

  }
}
