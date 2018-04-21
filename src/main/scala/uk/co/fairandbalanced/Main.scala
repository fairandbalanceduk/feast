package uk.co.fairandbalanced

import uk.co.fairandbalanced.http._

object Main extends App {
  
  val httpClient = HttpClient()
    
  println(httpClient.sendRequest)
  
}