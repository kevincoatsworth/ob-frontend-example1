package connectors

import com.google.inject.{ImplementedBy, Inject, Singleton}
import config.FrontEndAppConfig
import models.UserDetails
import play.api.libs.json.Json
import play.api.mvc.RequestHeader
import uk.gov.hmrc.http.{BadRequestException, HeaderCarrier}
import uk.gov.hmrc.play.bootstrap.http.HttpClient

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class UserConnector @Inject()(config: FrontEndAppConfig, http: HttpClient) extends UserConnectorInterface {

  def post(x: UserDetails)(implicit
                           headerCarrier: HeaderCarrier,
                           ec: ExecutionContext,
                           request: RequestHeader): Future[UserSubmissionResponse] = {

    val url = config.getUserUrl

    http.POST(url, Json.toJson(x), Seq("Content-Type" -> "application/json")).map {
      response =>
        response.status match {
          case 200 => SuccessfulSubmission
        }
    }.recover {
      case _: BadRequestException => FailedSubmission
    }

  }

}

@ImplementedBy(classOf[UserConnector])
trait UserConnectorInterface {
  def post(x: UserDetails)(implicit
                           headerCarrier: HeaderCarrier,
                           ec: ExecutionContext,
                           request: RequestHeader): Future[UserSubmissionResponse]
}

sealed trait UserSubmissionResponse
object SuccessfulSubmission extends UserSubmissionResponse
object FailedSubmission extends UserSubmissionResponse
