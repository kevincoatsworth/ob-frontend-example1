package controllers

import javax.inject._
import models.{UserDetails, UserName, UserTelephone, UserEmail}
import play.api.mvc._

@Singleton
class AddUserConfirmationController @Inject() extends Controller {

  def get = Action { implicit request =>

    val userName = request.session.get("name").getOrElse("not set")

    val userTelephone = request.session.get("telephone").getOrElse("not set")

    val userEmail = request.session.get("email").getOrElse("not set")

    val userDetails = UserDetails(name = UserName(userName), telephone = UserTelephone(userTelephone), email = UserEmail(userEmail))

    Ok(views.html.add_user_confirmation(userDetails))
  }
}
