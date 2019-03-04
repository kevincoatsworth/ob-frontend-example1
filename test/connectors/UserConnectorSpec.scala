package connectors

import config.FrontEndAppConfig
import models.{UserDetails, UserEmail, UserName, UserTelephone}
import org.mockito.ArgumentMatchers
import org.mockito.Mockito._
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.mockito.MockitoSugar
import org.scalatestplus.play.{OneAppPerSuite, PlaySpec}
import play.api.inject.Injector
import play.api.inject.guice.GuiceApplicationBuilder
import play.api.libs.json.JsValue
import play.api.mvc.RequestHeader
import play.api.test.FakeRequest
import uk.gov.hmrc.http.{BadRequestException, HeaderCarrier, HttpResponse}
import uk.gov.hmrc.play.bootstrap.http.HttpClient

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class UserConnectorSpec extends PlaySpec with OneAppPerSuite with MockitoSugar with ScalaFutures {

  import UserConnectorSpec._

  override lazy val app = new GuiceApplicationBuilder().build()

  def injector: Injector = app.injector

  def config: FrontEndAppConfig = app.injector.instanceOf[FrontEndAppConfig]

  val http = mock[HttpClient]

  val connector = new UserConnector(config, http)

  "UserConnectorSpec" should {

    "return SuccessfulSubmission when successful" in {

      when(http.POST[JsValue, HttpResponse](ArgumentMatchers.any(), ArgumentMatchers.any(), ArgumentMatchers.any())
        (ArgumentMatchers.any(), ArgumentMatchers.any(), ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(
        Future.successful(HttpResponse(200))
      )

      val result = connector.post(user)

      whenReady(result) {
        x => x mustBe SuccessfulSubmission
      }

    }

    "return FailedSubmission when unsuccessful" in {

      when(http.POST[JsValue, HttpResponse](ArgumentMatchers.any(), ArgumentMatchers.any(), ArgumentMatchers.any())
        (ArgumentMatchers.any(), ArgumentMatchers.any(), ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(
        Future.failed(new BadRequestException("bad request"))
      )

      val result = connector.post(user)

      whenReady(result) {
        x => x mustBe FailedSubmission
      }

    }

  }

}

object UserConnectorSpec {
  implicit val hc: HeaderCarrier = HeaderCarrier()
  implicit val rh: RequestHeader = FakeRequest("", "")

  val user = UserDetails(
    UserName("test"),
    UserTelephone("123456"),
    UserEmail("test@test.com"))
}
