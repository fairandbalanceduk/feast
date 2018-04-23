package uk.co.fairandbalanced.feast.logging

import com.typesafe.scalalogging.StrictLogging

trait Logging extends StrictLogging {}

object Logging {
  type Logger = com.typesafe.scalalogging.Logger
}
