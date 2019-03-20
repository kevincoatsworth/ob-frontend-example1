package controllers

import javax.inject.{Inject, Singleton}
import play.api.mvc._

@Singleton
class AboutUsController @Inject() extends Controller {

  def index = Action { implicit request =>
    Ok(views.html.about_us())
  }
}