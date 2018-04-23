package uk.co.fairandbalanced.feast.http.util
import akka.http.scaladsl.model.HttpResponse

import scala.concurrent.Future

class RichHttpResponseInjector(mockHttpResponse: Future[HttpResponse]) extends HttpResponseInjector {

  override def response(httpResponse: Future[HttpResponse]): Future[HttpResponse] = mockHttpResponse

}