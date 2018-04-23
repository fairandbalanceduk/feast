package uk.co.fairandbalanced.feast.service

import uk.co.fairandbalanced.feast.directives.RequestUnmarshaller
import uk.co.fairandbalanced.feast.domain.healthcheck.HCBody
import uk.co.fairandbalanced.feast.{BaseSpec, Config}
import uk.co.fairandbalanced.feast.http.{HttpActor, HttpClient, HttpRequestProvider}
import uk.co.fairandbalanced.feast.http.util._

import scala.concurrent.Future

class HealthCheckServiceSpec extends BaseSpec {

  // Mocked dependencies
  val config: Config = mock[Config]
  val httpActor: HttpActor = mock[HttpActor]
  val httpRequestProvider: HttpRequestProvider = new FakeHttpRequestProvider(config)
  val httpResponseInjector: HttpResponseInjector = new HttpResponseInjector()
  //val httpResponseInjector: HttpResponseInjector = new RichHttpResponseInjector(HttpResponseTemplates.jsonBody(HealthCheckTemplates.HCBody().asJson))
  val httpClient: HttpClient = new FakeHttpClient(httpActor, httpResponseInjector)

  "A HealthCheckService.healthCheck" should "return a Future[HCBody]" in {
    new HealthCheckService(httpClient, httpRequestProvider, new RequestUnmarshaller())
      .healthCheck().isInstanceOf[Future[HCBody]] shouldEqual true
  }

}