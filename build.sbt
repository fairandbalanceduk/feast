scalaVersion := "2.12.4"

name := "feast"
organization := "uk.co.fairandbalanced"
version := "0.0.1"

mainClass in Compile := Some("uk.co.fairandbalanced.Main")

libraryDependencies ++= Seq(
  "com.google.inject" % "guice" % "4.1.0",
  "com.typesafe.akka" %% "akka-actor" % "2.5.12",
  "com.typesafe.akka" %% "akka-http" % "10.1.1",
  "com.typesafe.akka" %% "akka-stream" % "2.5.12",
  "de.heikoseeberger" %% "akka-http-circe" % "1.18.0",
  "io.circe" %% "circe-generic" % "0.8.0",
  "io.circe" %% "circe-java8" % "0.8.0",
  "org.scalamock" %% "scalamock" % "4.1.0" % Test,
  "org.scalatest" %% "scalatest" % "3.0.4" % Test
)

scalacOptions ++= Seq(
  "-unchecked",
  "-deprecation",
  "-feature",
  "-Xfatal-warnings"
)
