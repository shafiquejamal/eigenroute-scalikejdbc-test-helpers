name := """eigenroute-scalikejdbc-test-helpers"""

version := "0.0.3"
organization := "com.eigenroute"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "org.scalikejdbc" %% "scalikejdbc"             % "2.4.2",
  "org.scalikejdbc" %% "scalikejdbc-config"      % "2.4.2",
  "org.scalikejdbc" %% "scalikejdbc-test"        % "2.4.2",
  "org.flywaydb" %% "flyway-play" % "3.0.1",
  "com.eigenroute" %% "eigenroute-scalikejdbc-helpers" % "0.0.3",
  "com.eigenroute" %% "eigenroute-util" % "0.0.3",
  "org.scalatest" %% "scalatest" % "2.2.4",
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1"
)

// resolvers += "Eigenroute maven repo" at "http://mavenrepo.eigenroute.com/"

publishMavenStyle := true
val resolver = Resolver.ssh("Eigenroute maven repo", "mavenrepo.eigenroute.com", 7835, "/home/mavenrepo/repo") withPermissions "0644"
publishTo := Some(resolver as ("mavenrepo", Path.userHome / ".ssh" / "id_rsa"))

publishArtifact in packageSrc := false

publishArtifact in packageDoc := false

