package uk.co.fairandbalanced.feast.http

import akka.http.scaladsl.model.HttpRequest
import uk.co.fairandbalanced.feast.{BaseSpec, Config}

class HttpRequestProviderSpec extends BaseSpec {

  // Mocked dependencies
  val config: Config = mock[Config]

  // Object under test
  val requestProvider: HttpRequestProvider = new HttpRequestProvider(config)

  "A RequestProvider.buildRequest" should "create an HttpRequest object" in {
    requestProvider.buildRequest("test") shouldEqual HttpRequest(uri = config.httpInterface + "test")
  }

}