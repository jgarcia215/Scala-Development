/*
  ***READ***
    Started to get sbt working for compiling with Plotly with the following guide
      https://www.scala-sbt.org/1.x/docs/sbt-by-example.html
    It hasn't been working out for me much. I'll work on this later but I'd
    appreciate it if you took a peek.
*/

ThisBuild / scalaVersion := "3.3.1"

lazy val grapher = project
  .in(file("."))
  .settings(
    name := "Grapher"
    libraryDependencies += "co.theasi" %% "plotly" % "0.2.0"
  )

lazy val parser = project
  .in(file("."))
  .settings(
    name := "Parser"
  )