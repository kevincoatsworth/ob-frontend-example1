package controllers

import com.google.inject.Inject
import play.api.i18n.{I18nSupport, MessagesApi}
import play.api.mvc.{Action, AnyContent, Controller}

class AddUserTelephoneController @Inject()(override val messagesApi: MessagesApi) extends Controller with I18nSupport {

  def get(): Action[AnyContent] = ???

  def post(): Action[AnyContent] = ???
}
