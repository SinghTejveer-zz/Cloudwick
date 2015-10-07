import sbt._

//class SampleProject(info: ProjectInfo) extends DefaultProject(info) {
//  val jackson = "org.codehaus.jackson" % "jackson-core-asl" % "1.6.1"
//  val specs = "org.scala-tools.testing" % "specs_2.8.0" % "1.6.5" % "test"
//}
libraryDependencies += "org.scala-tools.testing" %% "scalacheck" % "1.9" % "test"
libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.4"
