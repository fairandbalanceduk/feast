package uk.co.fairandbalanced.feast.directives

import io.circe.Json
import uk.co.fairandbalanced.feast.BaseSpec
import uk.co.fairandbalanced.feast.http.util.RichHttpResponseInjector
import uk.co.fairandbalanced.feast.templates.{HttpResponseTemplates, JsonTemplates}

import scala.concurrent.Future

class RequestUnmarshallerSpec extends BaseSpec {

  "A RequestUnmarshaller.unmarshal" should "return valid JSON" in {

    val result: Future[Json] = for {
      response <- new RichHttpResponseInjector(HttpResponseTemplates.jsonBody(JsonTemplates.trueJson)).response()
      json <- new RequestUnmarshaller().getJson(response)
    } yield json

    whenReady(result) { j: Json => j shouldEqual JsonTemplates.trueJson}

  }

}