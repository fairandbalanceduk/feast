package uk.co.fairandbalanced.http

import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import scala.concurrent.Future


case class HttpClient() extends HttpImplicits {
    
  def sendRequest(): Future[HttpResponse] = Http().singleRequest(HttpRequest(uri = "http://akka.io"))
    
}