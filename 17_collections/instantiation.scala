import scala.collection.immutable.TreeSet
import scala.collection.mutable.{Map => MMap}

val colors = List("blue", "yellow", "red", "green")
val treeSet: TreeSet[String] = TreeSet[String]() ++ colors
val muta = MMap("i" -> 1, "ii" -> 2)
val immu1 = Map() ++ muta
val immu2 = muta.toMap
