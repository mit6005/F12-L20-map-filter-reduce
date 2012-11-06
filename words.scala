import java.io.File
import scala.io._

def allFilesIn(f: File): List[File] = {
  val these = f.listFiles.toList
  these.filter(_.isFile) ++ these.filter(_.isDirectory).flatMap(allFilesIn)
}

def words(f: File): List[String] = {
  allFilesIn(f)
  .filter(_.getName.endsWith(".java"))
  .map(Source.fromFile(_).mkString)
  .flatMap(_.lines.toList)
  .flatMap(_.split(" ").toList)
}
