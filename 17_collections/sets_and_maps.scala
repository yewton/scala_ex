import scala.collection.mutable.{Map => MMap}
import scala.collection.mutable.{Set => MSet}
val mSet = MSet(1, 2, 3)

val text = "See Spot run. Run, Spot. Run!"
val wordsArray = text.split("[ !,.]+")
val words: MSet[String] = MSet()
for (word <- wordsArray) words += word.toLowerCase
words

val map: MMap[String, Int] = MMap()
map("hello") = 1
map("there") = 2
map
map("hello")

def countWords(text: String): Map[String, Int] = {
  val counts: MMap[String, Int] = MMap()
  for (word <- text.split("[ ,!.]+").map(_.toLowerCase)) {
    counts += (word -> (counts.getOrElse(word, 0) + 1))
  }
  counts.toMap
}
countWords(text)
