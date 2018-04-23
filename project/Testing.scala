import sbt.Keys._
import sbt._

object Testing {

  logBuffered in Test := false

  lazy val testAll = TaskKey[Unit]("test-all")
  lazy val testIt = TaskKey[Unit]("it")

  private lazy val itSettings =
    inConfig(IntegrationTest)(Defaults.testSettings) ++
      Seq(
        fork in IntegrationTest := false,
        parallelExecution in IntegrationTest := false,
        scalaSource in IntegrationTest := baseDirectory.value / "src/it/scala"
      )


  lazy val settings = itSettings ++ Seq(
    testAll := (test in  IntegrationTest).dependsOn(test in Test).value,
    testIt := (test in IntegrationTest).value
  )
}