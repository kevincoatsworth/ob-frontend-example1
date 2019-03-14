package controllers

import com.google.inject.Inject
import forms.UserNameForm
import play.api.i18n.{I18nSupport, MessagesApi}
import play.api.mvc.{Action, Controller}

class AddUserNameController @Inject()(override val messagesApi: MessagesApi) extends Controller with I18nSupport {

  private val form = UserNameForm()

  def get = Action { implicit request =>
    Ok(views.html.add_user_name(form))
  }

  def post() = Action { implicit request =>
    form.bindFromRequest.fold(
      formWithErrors => {
        BadRequest(views.html.add_user_name(formWithErrors))
      },
      _ => {
        Ok("form submitted!!!").as("text/html")
      }
    )
  }
}
