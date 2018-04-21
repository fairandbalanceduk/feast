package uk.co.fairandbalanced.http

import akka.http.scaladsl.Http
import akka.http.scaladsl.model._

import scala.concurrent.Future
import scala.util.{ Failure, Success }
import scala.concurrent.ExecutionContext.Implicits.global

case class HttpClient() extends HttpConfig {
    
  def sendRequest(): Future[HttpResponse] = {
      val result: Future[HttpResponse] = for {
        response <- Http().singleRequest(HttpRequest(uri = "http://akka.io"))
      } yield response
      
      whenReady(result) { r: HttpResponse => println(r) }
  }
  
    
}