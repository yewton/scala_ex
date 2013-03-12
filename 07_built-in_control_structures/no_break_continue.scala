import scala.util.control.Breaks._
import java.io._

var i = 0
var foundIt = false
while(i < args.length && !foundIt) {
  if (!args(i).startsWith("-")) {
    if (args(i).endsWith(".scala"))
      foundIt = true
  }
  i = i + 1
}

println("Found at ["+ i +"]")

def searchFrom(i: Int): Int =
  if (i >= args.length) -1
  else if (args(i).startsWith("-")) searchFrom(i + 1)
  else if (args(i).endsWith(".scala")) i
  else searchFrom(i + 1)

val j = searchFrom(0)
println("Found at ["+ i +"]")

val in = new BufferedReader(new InputStreamReader(System.in))
breakable {
  while (true) {
    println("? ")
    if (in.readLine() == "") break
  }
}
