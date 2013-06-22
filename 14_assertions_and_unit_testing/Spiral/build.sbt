name := "Spiral"

version := "0.1"

scalaVersion := "2.10.1"

libraryDependencies ++= Seq(
  "org.scalatest" % "scalatest_2.10"  % "1.9.1" % "test",
  "junit"         % "junit"           % "3.8.1" % "test",
  "org.testng"    % "testng"          % "6.8.5" % "test",
  "com.novocode"  % "junit-interface" % "0.8"   % "test->default"
)

scalacOptions += "-deprecation"
