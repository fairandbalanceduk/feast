package uk.co.fairandbalanced.feast.directives

import com.google.inject.Inject
import io.circe.Json
import uk.co.fairandbalanced.feast.http._
import scala.concurrent.Future

class RequestHandler @Inject()(httpClient: AbstractHttpClient,
                               httpRequestProvider: HttpRequestProvider,
                               requestUnmarshaller: RequestUnmarshaller) extends HttpImplicits {


  def handleRequest(path: String): Future[Json] = {
    val request = httpRequestProvider.buildRequest(path)
    for {
      response <- httpClient.sendRequest(request)
      entity <- requestUnmarshaller.getJson(response)
    } yield entity
  }

}