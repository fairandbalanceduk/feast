package uk.co.fairandbalanced.feast.directives

import akka.http.scaladsl.model.HttpResponse
import akka.http.scaladsl.unmarshalling.Unmarshal
import akka.stream.ActorMaterializer
import com.google.inject.Inject
import de.heikoseeberger.akkahttpcirce.ErrorAccumulatingCirceSupport._
import io.circe.Json
import scala.concurrent.Future

class RequestUnmarshaller @Inject()(implicit mat: ActorMaterializer) {

  def getJson(httpResponse: HttpResponse): Future[Json] = {
    Unmarshal(httpResponse).to[Json]
  }

}