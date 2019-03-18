package controllers

import com.google.inject.Inject
import forms.UserEmailForm
import play.api.i18n.{I18nSupport, MessagesApi}
import play.api.mvc.{Action, Controller}

class AddUserEmailController @Inject()(override val messagesApi: MessagesApi) extends Controller with I18nSupport {

  private val form = UserEmailForm()

  def get = Action { implicit request =>
    Ok(views.html.add_user_email(form))
  }

  def post() = Action { implicit request =>
    form.bindFromRequest.fold(
      formWithErrors => {
        BadRequest(views.html.add_user_email(formWithErrors))
      },
      _ => {
        Ok("form submitted!!!").as("text/html")
      }
    )
  }
}
