import sbt._
import sbt.Keys._

object DiscreteEventSimulationBuild extends Build {

  lazy val discreteEventSimulation = Project(
    id = "discrete-event-simulation",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "Discrete Event Simulation",
      organization := "net.yewton",
      version := "0.1-SNAPSHOT",
      scalaVersion := "2.10.1"
      // add other settings here
    )
  )
}
