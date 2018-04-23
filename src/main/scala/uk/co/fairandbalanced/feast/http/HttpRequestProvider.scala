package uk.co.fairandbalanced.feast.http

import akka.http.scaladsl.model.{HttpMethods, HttpRequest, Uri}
import com.google.inject.Inject
import uk.co.fairandbalanced.feast.Config

class HttpRequestProvider @Inject()(config: Config) {

  // Builds a GET request pointing at [config.httpInterface]/[path]
  def buildRequest(path: String): HttpRequest = HttpRequest(
    HttpMethods.GET,
    uri = Uri(config.httpInterface + path)
  )

}
