package controllers

import javax.inject._
import models.{UserDetails, UserName}
import play.api.mvc._

@Singleton
class AddUserConfirmationController @Inject() extends Controller {

  def get = Action { implicit request =>

    val userName = request.session.get("name").getOrElse("not set")

    val userDetails = UserDetails(name = UserName(userName))

    Ok(views.html.add_user_confirmation(userDetails))
  }
}
