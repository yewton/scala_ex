import net.yewton.exercise.scala.ex15._

object DemoApp extends App {
  def demo(title :String)(f: => Unit): (() => Unit) = { () =>
    println(s"""$title""")
    f
    println("""== EOD ==""")
  }
  def demo1 = demo("15.1.1 Case Class Demo") {
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
  }
  def demo2 = demo("15.1.2 Pattern Match Demo") {
    println("We want to simplyfi -(-x), x + 0, x * 1...")
    println(Expr.simplifyTop(UnOp("-", UnOp("-", Var("x")))))
    println(Expr.simplifyTop(BinOp("+", Var("x"), Number(0))))
    println(Expr.simplifyTop(BinOp("*", Var("x"), Number(1))))
    println("Very well!!")
  }
  demo1()
  demo2()
}
