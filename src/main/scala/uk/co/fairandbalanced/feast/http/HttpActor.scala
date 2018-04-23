package uk.co.fairandbalanced.feast.http

import akka.http.scaladsl.Http

class HttpActor extends HttpImplicits {

  val http = Http()

}