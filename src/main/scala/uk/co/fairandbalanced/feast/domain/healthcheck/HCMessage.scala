package uk.co.fairandbalanced.feast.domain.healthcheck

import io.circe.{Decoder, Encoder}
import io.circe.generic.semiauto._

case class HCMessage(
                    severity: String,
                    author: String,
                    created_at: String,
                    translations: List[HCTranslation],
                    updated_at: String,
                    content: String,
                    id: String
                    )

object HCMessage {
  implicit val decoder: Decoder[HCMessage] = deriveDecoder[HCMessage]
  implicit val encoder: Encoder[HCMessage] = deriveEncoder[HCMessage]
}