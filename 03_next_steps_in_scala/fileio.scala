import scala.io.Source

def widthOfLength(s: String) = s.length.toString.length
val lines = Source.fromFile(args(0)).getLines().toList

// var maxWidth = 0
// for (line <- lines)
//   maxWidth = maxWidth.max(widthOfLength(line))

val longestLine: String = lines.reduceLeft(
  (a: String, b: String) => if (a.length > b.length) a else b
)

val maxWidth = widthOfLength(longestLine)

for (line <- lines) {
  val numSpaces = maxWidth - widthOfLength(line)
  val padding = " " * numSpaces
  println(padding + line.length +" | "+ line)
}
