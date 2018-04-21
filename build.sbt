scalaVersion := "2.12.4"

name := "feast"
organization := "uk.co.fairandbalanced"
version := "1.0"

mainClass in Compile := Some("uk.co.fairandbalanced.Main")

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.5.12",
  "com.typesafe.akka" %% "akka-http"   % "10.1.1",
  "com.typesafe.akka" %% "akka-stream" % "2.5.12"
)
