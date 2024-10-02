ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.3"

lazy val root = (project in file("."))
  .settings(
    name := "Scala-sample"
  )

resolvers += "Akka library repository".at("https://repo.akka.io/maven")
val AkkaVersion = "2.9.5"
libraryDependencies += "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion