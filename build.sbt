name := """hall-of-fame"""

version := "0.0.0"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  ws
)

resolvers += "spray repo" at "http://repo.spray.io"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies += "io.spray" %% "spray-client" % "1.3.1"

libraryDependencies += "io.spray" %% "spray-can" % "1.3.1"

libraryDependencies += "io.spray" %% "spray-http" % "1.3.1"

libraryDependencies += "io.spray" %% "spray-httpx" % "1.3.1"

libraryDependencies += "io.spray" %% "spray-util" % "1.3.1"

libraryDependencies += "io.spray" %%  "spray-json" % "1.2.6"

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.3.2"