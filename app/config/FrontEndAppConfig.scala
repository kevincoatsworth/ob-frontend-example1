package config

import com.google.inject.{Inject, Singleton}
import play.api.Configuration

@Singleton
class FrontEndAppConfig @Inject()(config: Configuration) {

  private val domain = config.getString("services.backend.domain").getOrElse(
    throw new Exception("missing config value for userDomain"))

  private val uri = config.getString("services.backend.uri").getOrElse(
    throw new Exception("missing config value for userUri"))

  private val port = config.getString("services.backend.port").getOrElse(
    throw new Exception("missing config value for userPort"))

  private val protocol = config.getString("services.backend.protocol").getOrElse(
    throw new Exception("missing config value for userPort"))

  def getUserUrl = s"$protocol://$domain:$port$uri"
}