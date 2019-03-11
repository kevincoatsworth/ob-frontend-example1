package controllers

import play.api.mvc.{Action, Controller}

class AddUserNameController extends Controller {

  def get = Action { implicit request =>
    Ok(views.html.index())
  }
}
