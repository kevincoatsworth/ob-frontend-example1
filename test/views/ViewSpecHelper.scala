package views

import org.scalatestplus.play.{OneAppPerSuite, PlaySpec}
import play.api.i18n.{Messages, MessagesApi}
import play.api.test.FakeRequest
import play.filters.csrf.CSRF.Token
import play.filters.csrf.{CSRFConfigProvider, CSRFFilter}

class ViewSpecHelper extends PlaySpec with OneAppPerSuite {

  def addToken[T](fakeRequest: FakeRequest[T]) = {
    val csrfConfig     = app.injector.instanceOf[CSRFConfigProvider].get
    val csrfFilter     = app.injector.instanceOf[CSRFFilter]
    val token          = csrfFilter.tokenProvider.generateToken

    fakeRequest.copyFakeRequest(tags = fakeRequest.tags ++ Map(
      Token.NameRequestTag  -> csrfConfig.tokenName,
      Token.RequestTag      -> token
    )).withHeaders((csrfConfig.headerName, token))
  }

  implicit val messagesApi: MessagesApi = app.injector.instanceOf[MessagesApi]
  implicit val messages: Messages = messagesApi.preferred(FakeRequest())
}
