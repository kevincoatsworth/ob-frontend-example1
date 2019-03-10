package controllers

import javax.inject._
import play.api.mvc.{Action, Controller}

@Singleton
class AddUserController @Inject() extends Controller {

  def get = Action {
    implicit request =>
    Ok(views.html.add_user())
  }

}
