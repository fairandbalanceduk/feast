package uk.co.fairandbalanced.feast.http

import akka.http.scaladsl.model.HttpRequest
import uk.co.fairandbalanced.feast.{BaseSpec, Config}

class HttpRequestProviderSpec extends BaseSpec {

  // Mocked dependencies
  val config: Config = mock[Config]

  "A RequestProvider.buildRequest" should "generate an HttpRequest" in {
    new HttpRequestProvider(config).buildRequest("").isInstanceOf[HttpRequest] shouldEqual true
  }

  "A RequestProvider.buildRequest" should "generate an accurate URI in the HttpRequest" in {
    new HttpRequestProvider(config).buildRequest("test") shouldEqual HttpRequest(uri = config.httpInterface + "test")
  }

}