ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.1"

Compile / mainClass := Some("Main")

libraryDependencies ++= Seq (
  "org.jsoup" % "jsoup" % "1.14.3",
)

lazy val root = (project in file("."))
  .settings(
    name := "Web"
  )
