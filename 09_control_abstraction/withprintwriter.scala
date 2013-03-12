import java.io.File
import java.io.PrintWriter
import scala.io.Source

def withPrintWriter(file: File)(op: PrintWriter => Unit) {
  val writer = new PrintWriter(file)
  try {
    op(writer)
  } finally {
   writer.close()
  }
}

val filename = "date.txt"
val file = new File(filename)
withPrintWriter(file) {
  writer => writer.println(new java.util.Date)
}

(Source.fromFile(filename)).getLines().foreach(println)
