package uk.co.fairandbalanced.feast.http

import akka.http.scaladsl.model.{HttpRequest, HttpResponse}
import scala.concurrent.Future

trait HttpServer {

  def sendRequest(httpRequest: HttpRequest): Future[HttpResponse]

}