package uk.co.fairandbalanced.feast

import com.typesafe.config.ConfigFactory

trait Config {

  private val config = ConfigFactory.load("application.conf")

  val httpInterface: String = config.getString("http.interface")

  val apiKey: Option[String] = if (config.hasPath("auth.apiKey")) {
    Some(config.getString("auth.apiKey"))
  } else {
    None
  }

}