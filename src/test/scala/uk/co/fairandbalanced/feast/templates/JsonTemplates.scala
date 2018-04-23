package uk.co.fairandbalanced.feast.templates

import io.circe.{Json, JsonObject}
import io.circe.syntax._

object JsonTemplates {

  val trueJson: Json = Json.fromJsonObject(JsonObject.fromMap(Map(("test", true.asJson))))

}