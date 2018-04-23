package uk.co.fairandbalanced.feast.domain.healthcheck

import io.circe.{Decoder, Encoder}
import io.circe.generic.semiauto._

case class HCBody(
                 name: String,
                 region_tag: String,
                 hostname: String,
                 services: List[HCService],
                 slug: String,
                 locales: List[String]
                 )

object HCBody {
  implicit val decoder: Decoder[HCBody] = deriveDecoder[HCBody]
  implicit val encoder: Encoder[HCBody] = deriveEncoder[HCBody]
}