// give the user a nice default project!
val sharedSettings = Seq(
  scalaVersion := DependencyVersions.scalaVersion,
  organization := "$organization$",
  scalacOptions ++=  Seq("-Yretain-trees") //necessary in zio-json if any case classes have default parameters
)


lazy val root = project.in(file(".")).
  aggregate($name$.js, $name$.jvm).
  settings(sharedSettings,
    publish := {},
    publishLocal := {}

  )

lazy val $name$ = crossProject(JSPlatform, JVMPlatform).crossType(CrossType.Full).in(file("."))
  .settings(
    name := "$name$",
    version := "0.1-SNAPSHOT",
    sharedSettings,
    libraryDependencies ++= Dependencies.zioJson.value,
    libraryDependencies ++= Dependencies.scalatest.value

  ).
  jvmSettings(
    // Add JVM-specific settings here
    libraryDependencies ++= Seq(
      Dependencies.zioHttp, 
      Dependencies.zioTest, 
      Dependencies.zioTestSBT, 
      Dependencies.zioTestMagnolia
    )
  ).
  jsSettings(
    // Add JS-specific settings here
    libraryDependencies ++= Dependencies.sttp.value,
    scalaJSUseMainModuleInitializer := true,
  )