import Dependencies._

name := """scala-vote-blockchain"""
version := "1.0"
scalaVersion := "2.12.6"

libraryDependencies ++= Seq(
  "org.scalaj" %% "scalaj-http" % "2.4.0",
  "com.typesafe.play" %% "play-json" % "2.6.9",
  "com.typesafe.akka" %% "akka-testkit" % "2.5.13" % Test,
  "com.typesafe.akka" %% "akka-actor" % "2.5.13",
  "com.typesafe.akka" %% "akka-http" % "10.1.3",
  "com.typesafe.akka" %% "akka-stream" % "2.5.15",
  "com.typesafe.akka" %% "akka-http-spray-json" % "10.1.3",
  "org.apache.kafka" % "kafka-clients" % "2.0.0",
  "joda-time" % "joda-time" % "2.10",
  "org.json4s" %% "json4s-jackson" % "3.5.0",
  "org.bouncycastle" % "bcprov-jdk16" % "1.46",
  "org.bouncycastle" % "bcmail-jdk16" % "1.46"
)
