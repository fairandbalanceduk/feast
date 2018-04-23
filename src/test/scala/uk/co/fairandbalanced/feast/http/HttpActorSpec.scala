package uk.co.fairandbalanced.feast.http

import akka.http.scaladsl.HttpExt
import uk.co.fairandbalanced.feast.BaseSpec

class HttpActorSpec extends BaseSpec {

  "A new HttpActor" should "have a valid http member" in {
    new HttpActor().http.isInstanceOf[HttpExt] shouldEqual true
  }

}