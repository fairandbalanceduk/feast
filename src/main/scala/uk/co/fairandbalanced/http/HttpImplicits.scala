package uk.co.fairandbalanced.http

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import scala.concurrent.ExecutionContextExecutor


trait HttpImplicits {
    
  implicit val materializer: ActorMaterializer = ActorMaterializer()
  implicit val system: ActorSystem = ActorSystem()
  implicit val executionContext: ExecutionContextExecutor = system.dispatcher
    
}