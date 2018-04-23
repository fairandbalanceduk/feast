package uk.co.fairandbalanced.feast.http.util

import akka.http.scaladsl.model.{HttpRequest, HttpResponse}
import com.google.inject.Inject
import uk.co.fairandbalanced.feast.http.{HttpActor, HttpClient}

import scala.concurrent.Future

class FakeHttpClient @Inject()(httpActor: HttpActor, httpResponseInjector: HttpResponseInjector) extends HttpClient(httpActor) {

  override def sendRequest(httpRequest: HttpRequest): Future[HttpResponse] = httpResponseInjector.response()

}