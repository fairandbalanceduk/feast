package uk.co.fairandbalanced.feast.http.util

import akka.http.scaladsl.model.HttpRequest
import com.google.inject.Inject
import uk.co.fairandbalanced.feast.Config
import uk.co.fairandbalanced.feast.http.HttpRequestProvider

class FakeHttpRequestProvider @Inject()(config: Config) extends HttpRequestProvider(config) {

  override def buildRequest(path: String): HttpRequest = HttpRequest()

}