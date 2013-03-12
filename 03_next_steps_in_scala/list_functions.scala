List()
// res0: List[Nothing] = List()
List("Cool", "tools", "rule")
// res1: List[String] = List(Cool, tools, rule)
val thrill = "Will" :: "fill" :: "untill" :: Nil // cons ... construct
// thrill: List[String] = List(Will, fill, untill)
List("a", "b") ::: List("c", "d")
// res2: List[String] = List(a, b, c, d)
thrill(2)
// res3: String = untill
thrill.count(s => s.length == 4)
// res4: Int = 2
thrill.drop(2) // Returns the thrill list without its first 2 elements
// res5: List[String] = List(untill)
thrill.dropRight(2)
// List[String] = List(Will)
thrill.exists(s => s == "untill")
// res7: Boolean = true
thrill.filter(s => s.length == 4)
// res8: List[String] = List(Will, fill)
thrill.forall(s => s.endsWith("l"))
// res9: Boolean = true
thrill.foreach(s => print(s))
// Willfilluntill
thrill.foreach(print) // Same as the previous, but more concise
// Willfilluntill
thrill.head
// res12: String = Will
thrill.init // Returns a list of all but the last element in the thrill list
// res13: List[String] = List(Will, fill)
thrill.isEmpty
// res14: Boolean = false
thrill.last
// res15: String = untill
thrill.length
// res16: Int = 3
thrill.map(s => s + "y")
// List[String] = List(Willy, filly, untilly)
thrill.mkString(", ")
// res18: String = Will, fill, untill
// thrill.remove(s => s.length == 4) -> doesn't work on Scala 2.10.0
thrill.filterNot(s => s.length == 4)
// res29: List[String] = List(untill)
thrill.reverse
// res20: List[String] = List(untill, fill, Will)
// thrill.sorted((s, t) => s.charAt(0).toLower < t.charAt(0).toLower) -> doesn't work on Scala 2.10.0
thrill.sortWith((s, t) => s.charAt(0).toLower < t.charAt(0).toLower)
// List[String] = List(fill, untill, Will)
thrill.tail
// res22: List[String] = List(fill, untill)
