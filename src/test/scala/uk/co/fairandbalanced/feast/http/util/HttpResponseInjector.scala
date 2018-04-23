package uk.co.fairandbalanced.feast.http.util

import akka.http.scaladsl.model.{HttpResponse, StatusCodes}

import scala.concurrent.Future

class HttpResponseInjector {

  def response(httpResponse: Future[HttpResponse] = Future.successful(HttpResponse(StatusCodes.OK))): Future[HttpResponse] = httpResponse

}