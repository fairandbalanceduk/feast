package uk.co.fairandbalanced.feast.http

import akka.http.scaladsl.model.{HttpRequest, HttpResponse, StatusCodes}
import scala.concurrent.Future

class MockServer extends HttpServer {

  override def sendRequest(httpRequest: HttpRequest): Future[HttpResponse] = Future.successful(HttpResponse(StatusCodes.OK))

}