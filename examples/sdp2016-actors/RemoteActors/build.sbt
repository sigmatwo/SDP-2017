name := "remote-actors"

version := "1.0"

description := "A simple chat server/client app demonstrating the Akka actors model"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

scalaVersion := "2.11.7"

lazy val akkaVersion = "2.4.1"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-testkit" % akkaVersion,
  "com.typesafe.akka" %% "akka-remote" % akkaVersion,
  "jline" % "jline" % "2.13",
  "joda-time" % "joda-time" % "2.9.2"
)
