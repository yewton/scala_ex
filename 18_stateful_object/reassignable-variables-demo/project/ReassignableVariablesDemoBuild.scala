import sbt._
import sbt.Keys._

object ReassignableVariablesDemoBuild extends Build {

  lazy val reassignableVariablesDemo = Project(
    id = "reassignable-variables-demo",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "Reassignable Variables Demo",
      organization := "net.yewton",
      version := "0.1-SNAPSHOT",
      scalaVersion := "2.10.1"
      // add other settings here
    )
  )
}
