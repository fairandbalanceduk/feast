package uk.co.fairandbalanced.feast.http

import akka.http.scaladsl.model.{HttpRequest, HttpResponse}

import scala.concurrent.Future

abstract class AbstractHttpClient {

  def sendRequest(httpRequest: HttpRequest): Future[HttpResponse]

}