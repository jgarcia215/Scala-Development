ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.1"

Compile / mainClass := Some("Main")

libraryDependencies ++= Seq (
  "org.jsoup" % "jsoup" % "1.14.3",
  "co.theasi" %% "plotly" % "0.2.0",
  "org.plotly-scala" %% "plotly-render" % "0.8.1"
)

lazy val root = (project in file("."))
  .settings(
    name := "Web"
  )
