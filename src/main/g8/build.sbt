// give the user a nice default project!
val sharedSettings = Seq(
  scalaVersion := DependencyVersions.scalaVersion,
  organization := "org.aurora"
)

lazy val root = project.in(file(".")).
  aggregate(foo.js, foo.jvm).
  settings(sharedSettings,
    publish := {},
    publishLocal := {}

  )

lazy val foo = crossProject(JSPlatform, JVMPlatform).crossType(CrossType.Full).in(file("."))
  .settings(
    name := "foo",
    version := "0.1-SNAPSHOT",
    sharedSettings,
    libraryDependencies ++= Dependencies.upickle.value,
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