package uk.co.fairandbalanced.http

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer

trait HttpConfig {
    
  implicit val materializer: ActorMaterializer = ActorMaterializer()
  implicit val system: ActorSystem = ActorSystem()
  implicit val executionContext = system.dispatcher
    
}