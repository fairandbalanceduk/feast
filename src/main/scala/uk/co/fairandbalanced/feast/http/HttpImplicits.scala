package uk.co.fairandbalanced.feast.http

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import scala.concurrent.ExecutionContextExecutor

trait HttpImplicits {

  // Implicit values required for sending/receiving HTTP traffic with Akka
  implicit val system: ActorSystem = ActorSystem()
  implicit val materializer: ActorMaterializer = ActorMaterializer()
  implicit val executionContext: ExecutionContextExecutor = system.dispatcher

}
