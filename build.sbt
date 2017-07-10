lazy val commonSettings = Seq(
  scalaVersion := "2.11.8",
  name := """play-scala""",
  version := "0.1.0-SNAPSHOT",
  test in assembly := {},
  logLevel in Global := Level.Info
)

lazy val root = (project in file(".")).
  settings(commonSettings: _*).
  settings(
    mainClass in assembly := Some("play.core.server.ProdServerStart"),
    fullClasspath in assembly += Attributed.blank(PlayKeys.playPackageAssets.value),
    logLevel in assembly := Level.Info
  ).enablePlugins(PlayScala)


libraryDependencies += cache
libraryDependencies += ws
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "2.+" % Test
libraryDependencies += "org.mockito" % "mockito-core" % "2.+" % Test
libraryDependencies +=  "jp.t2v" %% "play2-auth"        % "0.14.2"
libraryDependencies +=  "jp.t2v" %% "play2-auth-social" % "0.14.2"
libraryDependencies +=  "jp.t2v" %% "play2-auth-test"   % "0.14.2" % Test
libraryDependencies +=  play.sbt.Play.autoImport.cache
libraryDependencies +=  "mysql" % "mysql-connector-java" % "5.1.39"
libraryDependencies +=  "com.typesafe.play" %% "play-slick" % "2.0.0"
libraryDependencies +=  "com.typesafe.play" %% "play-slick-evolutions" % "2.0.0"
libraryDependencies += "com.github.t3hnar" %% "scala-bcrypt" % "3.0"
libraryDependencies += evolutions

resolvers in Global ++= Seq(
  "Sbt plugins"                   at "https://dl.bintray.com/sbt/sbt-plugin-releases",
  "Maven Central Server"          at "http://repo1.maven.org/maven2",
  "TypeSafe Repository Releases"  at "http://repo.typesafe.com/typesafe/releases/",
  "TypeSafe Repository Snapshots" at "http://repo.typesafe.com/typesafe/snapshots/"
)

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}

javaOptions in Test += "-Dconfig.file=conf/test.conf"