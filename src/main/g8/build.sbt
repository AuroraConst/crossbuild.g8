// give the user a nice default project!
val sharedSettings = Seq(
  scalaVersion := DependencyVersions.scalaVersion,
  organization := "$organization$"
)

lazy val root = project.in(file(".")).
  aggregate(foo.js, foo.jvm).
  settings(sharedSettings,
    publish := {},
    publishLocal := {},
  )

lazy val foo = crossProject(JSPlatform, JVMPlatform).crossType(CrossType.Full).in(file("."))
  .settings(
    name := "foo",
    version := "0.1-SNAPSHOT",
    libraryDependencies ++= Dependencies.upickle.value,
    libraryDependencies ++= Dependencies.scalatest.value

  ).
  jvmSettings(
    // Add JVM-specific settings here
  ).
  jsSettings(
    // Add JS-specific settings here
    scalaJSUseMainModuleInitializer := true,
  )