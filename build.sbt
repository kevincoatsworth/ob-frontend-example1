name := """ob-frontend-example1"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.12"

libraryDependencies += filters
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "2.0.1" % Test
libraryDependencies += "org.jsoup" % "jsoup" % "1.8.3" % Test
libraryDependencies += "org.mockito" % "mockito-core" % "2.13.0" % Test
libraryDependencies += "com.github.tomakehurst" % "wiremock" % "2.7.1" % Test

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"

resolvers += Resolver.bintrayRepo("hmrc", "releases")

libraryDependencies += "uk.gov.hmrc" %% "bootstrap-play-25" % "4.12.0"
