package uk.co.fairandbalanced.feast.http

import akka.http.scaladsl.model.{HttpRequest, HttpResponse}
import com.google.inject.Inject

import scala.concurrent.Future

class HttpClient @Inject()(httpActor: HttpActor) extends AbstractHttpClient {

  def sendRequest(httpRequest: HttpRequest): Future[HttpResponse] = httpActor.http.singleRequest(httpRequest)

}