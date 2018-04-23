package uk.co.fairandbalanced.feast.domain.healthcheck

import io.circe.{Decoder, Encoder}
import io.circe.generic.semiauto._

case class HCIncident(
                     active: Boolean,
                     created_at: String,
                     id: Long,
                     updates: List[HCMessage]
                     )

object HCIncident {
  implicit val decoder: Decoder[HCIncident] = deriveDecoder[HCIncident]
  implicit val encoder: Encoder[HCIncident] = deriveEncoder[HCIncident]
}