import sbt.Keys.{libraryDependencies, name}
import sbt._

object UtilBuild extends Build {
    lazy val codecUtil =  Project("CodecUtil", file("CodecUtil"))
            .settings(
                name := "CodecUtil",
                libraryDependencies ++= Seq(
                    "org.scalatest" %% "scalatest" % "2.2.6"
                )
            )
    lazy val basicUtil = Project("BasicUtil", file("BasicUtil"))
            .settings(
              name := "BasicUtil",
              libraryDependencies ++= Seq(
                  "org.scalatest" %% "scalatest" % "2.2.6"
              )
            )

    lazy val scala_util_all = (project in file("."))
            .aggregate(`codecUtil`)
}