package uk.co.fairandbalanced.feast

import org.scalamock.scalatest.MockFactory
import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.time.{Millis, Seconds, Span}

class BaseSpec extends FlatSpec with MockFactory with Matchers with ScalaFutures with BeforeAndAfter {

  private val intervalDuration: Int = 500

  //This needs to be added to extend the default wait and interval time for futures
  implicit val defaultPatience: PatienceConfig = PatienceConfig(timeout = Span(5, Seconds), interval = Span(intervalDuration, Millis))

}