name := "Spiral"

version := "0.1"

scalaVersion := "2.10.1"

libraryDependencies ++= Seq(
  "org.scalatest"  %% "scalatest"       % "1.9.1"  % "test",
  "junit"          %  "junit"           % "3.8.1"  % "test",
  "org.testng"     %  "testng"          % "6.1.1"  % "test",
  "com.novocode"   %  "junit-interface" % "0.8"    % "test->default",
  "org.specs2"     %% "specs2"          % "2.0"    % "test",
  "org.scalacheck" %% "scalacheck"      % "1.10.1" % "test"
)

scalacOptions += "-deprecation"
