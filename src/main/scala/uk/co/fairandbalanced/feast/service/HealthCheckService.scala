package uk.co.fairandbalanced.feast.service

import akka.http.scaladsl.model.HttpResponse
import com.google.inject.Inject
import io.circe.Json
import scala.concurrent.ExecutionContext.Implicits.global
import uk.co.fairandbalanced.feast.directives.RequestUnmarshaller
import uk.co.fairandbalanced.feast.domain.healthcheck.HCBody
import uk.co.fairandbalanced.feast.http.{HttpClient, HttpRequestProvider}

import scala.concurrent.Future

class HealthCheckService @Inject()(httpClient: HttpClient,
                                   httpRequestProvider: HttpRequestProvider,
                                   requestUnmarshaller: RequestUnmarshaller) {

  private val healthCheckVersion: Int = 3
  private val healthCheckPath: String = s"/status/v$healthCheckVersion/shard-data"

  private def requestHealthCheck(): Future[HttpResponse] = httpClient.sendRequest(httpRequestProvider.buildRequest(healthCheckPath))

  private def decodeHealthCheckJson(json: Json): Future[HCBody] = json.as[HCBody] match {
    case Right(hc) => Future.successful(hc)
    case Left(df) => Future.failed(df)
  }

  def healthCheck(): Future[HCBody] = for {
    response <- requestHealthCheck()
    json <- requestUnmarshaller.getJson(response)
    hc <- decodeHealthCheckJson(json)
  } yield hc

}