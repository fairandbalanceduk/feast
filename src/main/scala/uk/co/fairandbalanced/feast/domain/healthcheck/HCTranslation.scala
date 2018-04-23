package uk.co.fairandbalanced.feast.domain.healthcheck

import io.circe.{Decoder, Encoder}
import io.circe.generic.semiauto._

case class HCTranslation(
                        locale: String,
                        content: String,
                        updated_at: String
                        )

object HCTranslation {
  implicit val decoder: Decoder[HCTranslation] = deriveDecoder[HCTranslation]
  implicit val encoder: Encoder[HCTranslation] = deriveEncoder[HCTranslation]
}