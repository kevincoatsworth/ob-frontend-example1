package controllers

import org.scalatestplus.play.{OneAppPerSuite, PlaySpec}
import play.api.i18n.MessagesApi
import play.api.inject.Injector

class AddUserEmailControllerSpec extends PlaySpec with OneAppPerSuite {

  def injector: Injector = app.injector

  def messagesApi: MessagesApi = injector.instanceOf[MessagesApi]

  "AddUserEmailController" when {

    "GET is called" should {

      "render the page from a new instance of controller" in {

      }

      "render the page from the application" in {

      }

      "render the page from the router" in {

      }

    }

    "POST is called" should {

      "accept a post request and return no products" in {

      }

      "accept a post request and return 400 if data is invalid" in {

      }

    }

  }
}
