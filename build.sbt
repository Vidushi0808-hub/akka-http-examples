//import sbt.Keys._
import sbt._


name := "akka-http-helloworld"

version := "1.0"

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
 "com.typesafe.akka" % "akka-actor_2.11" % "2.3.4",
 "com.typesafe.akka" %% "akka-http-spray-json-experimental" % "1.0",
 "com.typesafe.akka" %%"akka-http-testkit-experimental" % "1.0",
 "org.scalatest" %% "scalatest" % "2.2.5" % "test"
 )
