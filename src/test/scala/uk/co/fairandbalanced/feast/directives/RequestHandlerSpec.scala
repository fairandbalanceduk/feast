package uk.co.fairandbalanced.feast.directives

import io.circe.Json

import scala.concurrent.Future
import uk.co.fairandbalanced.feast.http._
import uk.co.fairandbalanced.feast.http.util.{FakeHttpClient, FakeHttpRequestProvider, HttpResponseInjector, RichHttpResponseInjector}
import uk.co.fairandbalanced.feast.templates.{HttpResponseTemplates, JsonTemplates}
import uk.co.fairandbalanced.feast.{BaseSpec, Config}

class RequestHandlerSpec extends BaseSpec {

  // Mocked dependencies
  val config: Config = mock[Config]
  val httpActor: HttpActor = mock[HttpActor]
  val httpResponseInjector = new HttpResponseInjector
  val httpClient: AbstractHttpClient = new FakeHttpClient(httpActor, httpResponseInjector)
  val httpRequestProvider: HttpRequestProvider = new FakeHttpRequestProvider(config)
  val requestUnmarshaller: RequestUnmarshaller = new RequestUnmarshaller()

  "A RequestHandler.handleRequest" should "return a Future[Json]" in {
    new RequestHandler(httpClient, httpRequestProvider, requestUnmarshaller)
      .handleRequest("").isInstanceOf[Future[Json]] shouldEqual true
  }

  "A RequestHandler.handleRequest" should "be able to unmarshal Json.Null" in {
    val responseInjector = new RichHttpResponseInjector(HttpResponseTemplates.jsonBody(JsonTemplates.trueJson))
    val fakeHttpClient = new FakeHttpClient(httpActor, responseInjector)
    val handledJson: Future[Json] = for {
      json <- new RequestHandler(fakeHttpClient, httpRequestProvider, requestUnmarshaller).handleRequest("")
    } yield json
    whenReady(handledJson) { j: Json => j shouldEqual JsonTemplates.trueJson }
  }

}