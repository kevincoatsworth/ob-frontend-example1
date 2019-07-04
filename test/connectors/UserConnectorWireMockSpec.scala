package connectors

import com.github.tomakehurst.wiremock.client.WireMock._
import models.{UserDetails, UserEmail, UserName, UserTelephone}
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.mockito.MockitoSugar
import org.scalatestplus.play.PlaySpec
import play.api.libs.json.Json
import play.api.mvc.RequestHeader
import play.api.test.FakeRequest
import uk.gov.hmrc.http.HeaderCarrier
import utils.WiremockHelper

import scala.concurrent.ExecutionContext.Implicits.global

class UserConnectorWireMockSpec extends PlaySpec with MockitoSugar with ScalaFutures with WiremockHelper {

  import UserConnectorWireMockSpec._

  override def beforeEach(): Unit = {
    super.beforeEach()
  }

  override protected def portConfigKey: String = "services.backend.port"

  def connector: UserConnectorInterface = app.injector.instanceOf[UserConnectorInterface]

  "UserConnectorWireMockSpec" should {

    "return SuccessfulSubmission when post is successful" in {

      server.stubFor(
        post(urlEqualTo(url))
          .withHeader("Content-Type", equalTo("application/json"))
          .withRequestBody(equalToJson(Json.stringify(Json.toJson(user))))
          .willReturn(
            ok.withHeader("Content-Type", "application/json")
          )
      )

      val result = connector.post(user)

      whenReady(result) {
        response => response mustBe SuccessfulSubmission
      }
    }

    "return FailedSubmission when post is unsuccessful" in {

      server.stubFor(
        post(urlEqualTo(url))
          .willReturn(
            badRequest
          )
      )

      val result = connector.post(user)

      whenReady(result) {
        response => response mustBe FailedSubmission
      }
    }

  }

}

object UserConnectorWireMockSpec {
  private implicit val hc: HeaderCarrier = HeaderCarrier()
  private implicit val rh: RequestHeader = FakeRequest("", "")

  private val url = "/user"

  private val user = UserDetails(
    UserName("test"),
    UserTelephone("123456"),
    UserEmail("test@test.com"))
}