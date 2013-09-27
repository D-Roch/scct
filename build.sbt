organization := "com.github.seratch.reaktor"

name := "scct"

version := "0.2.001"

scalaVersion := "2.10.2"

libraryDependencies <+= (scalaVersion) { v =>
  "org.scala-lang" % "scala-compiler" % v % "provided"
}

libraryDependencies ++= Seq(
  "junit"       %  "junit"       % "4.11"  % "test",
  "org.mockito" %  "mockito-all" % "1.9.5" % "test",
  "org.specs2"  %% "specs2"      % "1.14"  % "test"
)

publishTo <<= version { (v: String) => 
  val nexus = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT")) Some("snapshots" at nexus + "content/repositories/snapshots")
  else Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

testOptions in Test <+= (scalaVersion in Test) map { (scalaVer) => 
  Tests.Setup { () => System.setProperty("scct-test-scala-version", scalaVer) } 
}

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { x => false }

pomExtra := <url>http://seratch.github.com/scalikejdbc</url>
  <licenses>
    <license>
      <name>Apache License, Version 2.0</name>
      <url>http://www.apache.org/licenses/LICENSE-2.0.html</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>git@github.com:seratch/scct.git</url>
    <connection>scm:git:git@github.com:seratch/scct.git</connection>
  </scm>
  <developers>
    <developer>
      <id>mtkopone</id>
      <name>Mikko Koponen</name>
      <url>http://mtkopone.github.com</url>
    </developer>
  </developers>

scalariformSettings
