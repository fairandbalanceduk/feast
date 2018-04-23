package uk.co.fairandbalanced.feast

import com.typesafe.config.ConfigFactory

trait Config {

  private val config = ConfigFactory.load("application.conf")

  val httpInterface: String = config.getString("http.interface")

}