package uk.co.fairandbalanced.feast.templates

import akka.http.scaladsl.model._
import akka.util.ByteString
import io.circe.Json
import scala.concurrent.Future

object HttpResponseTemplates {

  def jsonBody(json: Json): Future[HttpResponse] = Future.successful(
    HttpResponse(
      entity = HttpEntity(
        MediaTypes.`application/json`,
        ByteString(json.spaces2)
      )
    )
  )

}