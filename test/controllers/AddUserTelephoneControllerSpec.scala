package controllers

import org.scalatestplus.play.{OneAppPerSuite, PlaySpec}
import play.api.i18n.MessagesApi
import play.api.inject.Injector
import play.api.libs.json.Json
import play.api.test.FakeRequest
import play.api.test.Helpers._

class AddUserTelephoneControllerSpec extends PlaySpec with OneAppPerSuite {

  def injector: Injector = app.injector

  def messagesApi: MessagesApi = injector.instanceOf[MessagesApi]

  "AddUserNameController" when {

    "GET is called" should {

      "render the page from a new instance of controller" in {
        val controller = new AddUserTelephoneController(messagesApi)
        val csrfAddToken = app.injector.instanceOf[play.filters.csrf.CSRFAddToken]
        val action = csrfAddToken(controller.get())
        val request = action(FakeRequest())

        status(request) mustBe OK
        contentType(request) mustBe Some("text/html")
      }

      "render the page from the application" in {
        val controller = app.injector.instanceOf[AddUserTelephoneController]
        val csrfAddToken = app.injector.instanceOf[play.filters.csrf.CSRFAddToken]
        val action = csrfAddToken(controller.get())
        val request = action(FakeRequest())

        status(request) mustBe OK
        contentType(request) mustBe Some("text/html")
      }

      "render the page from the router" in {
        val request = FakeRequest(GET, "/add-user/telephone").withHeaders("Host" -> "localhost")
        val home = route(app, request).get

        status(home) mustBe OK
        contentType(home) mustBe Some("text/html")
      }

    }

    "POST is called" should {

      "accept a post request and return 200" in {
        val controller = new AddUserTelephoneController(messagesApi)
        val csrfAddToken = app.injector.instanceOf[play.filters.csrf.CSRFAddToken]
        val action = csrfAddToken(controller.post())
        val request = action(FakeRequest().withJsonBody(Json.obj("telephone" -> "123456")))
        status(request) mustBe 200
        contentType(request) mustBe Some("text/html")
      }

      "accept a post request and return 400 if data is invalid" in {
        val controller = new AddUserTelephoneController(messagesApi)
        val csrfAddToken = app.injector.instanceOf[play.filters.csrf.CSRFAddToken]
        val action = csrfAddToken(controller.post())
        val request = action(FakeRequest().withJsonBody(Json.obj("telephone" -> "")))
        status(request) mustBe 400
        contentType(request) mustBe Some("text/html")
        contentAsString(request) must include("Numeric value expected")
      }

    }
  }
}
