import net.yewton.exercise.scala.ex15._

object DemoApp extends App {
  println("""== Case Class Demo ==""")
  println("""1. Factory method with the name of the class""")
  val v = Var("x")
  val op = BinOp("+", Number(1), v)
  println(v)
  println(op)
  println("""|2. All the arguments of a case class implicitly
             |get a val prefix, so they are maintained as fields""".stripMargin)
  println(v.name)
  println(op.lhs)
  println("""3. They have "natural" implementations of methods `toString`, `hashCode`, and `equals`""")
  println(op.rhs == Var("x"))
  println("""4. A copy method to your class for making modified copies.""")
  println("""- Making an BinOp instance with operator "-" from an existing instance having "+"""")
  println(op.copy(operator = "-"))
  println("""== EOD ==""")
}
