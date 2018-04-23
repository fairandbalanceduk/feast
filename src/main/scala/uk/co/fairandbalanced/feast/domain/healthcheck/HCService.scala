package uk.co.fairandbalanced.feast.domain.healthcheck

import io.circe.{Decoder, Encoder}
import io.circe.generic.semiauto._

case class HCService(
                    status: String,
                    incidents: List[HCIncident],
                    name: String,
                    slug: String
                    )

object HCService {
  implicit val decoder: Decoder[HCService] = deriveDecoder[HCService]
  implicit val encoder: Encoder[HCService] = deriveEncoder[HCService]
}