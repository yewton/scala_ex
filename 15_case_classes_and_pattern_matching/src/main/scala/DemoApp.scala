import net.yewton.exercise.scala.ex15.expr._

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
  def demo3 = demo("15.2.1 Wildcard Patterns") {
    println("_ is a wildcard pattern.")
    def describe(expr: Expr) = expr match {
      case BinOp(_, _, _) => println(expr +" is a binary operation")
      case _ => // do nothing
    }
    describe(BinOp("+", Var("x"), Var("y")))
    describe(Var("x"))
  }
  def demo4 = demo("15.2.2 Constant Patterns") {
    println("A constant pattern matches only itself.")
    def describe(x: Any): String = x match {
      case 5 => "five"
      case true => "truth"
      case "hello" => "hi!"
      case Nil => "the empty list"
      case _ => "something else"
    }
    Seq(5, true, "hello", Nil, List(1, 2, 3)).foreach { x =>
      println(describe(x))
    }
  }
  def demo5 = demo("15.2.3 Variable Patterns") {
    println("A variable pattern matches any object, just like a wildcard.")
    println("Unlike a wildcard, Scala binds the variable to whatever the object is.")
    println(1 match {
      case 0 => "zero"
      case somethingElse => "not zero: "+ somethingElse
    })
  }
  def demo6 = demo("15.2.3.1 Variable or constant?") {
    import math.{E, Pi}
    println("It's a variable if the pattern starts with a lowercase,")
    println("otherwise it's a constant.")
    E match {
      case Pi => println("strange math? Pi = "+ Pi)
      case _ => println("OK")
    }
    val pi = Pi
    E match {
      case pi => println("strange math? Pi = "+ pi)
    }
    println("If you need to use a constant pattern its name starts with a lowercase,")
    println("enclose it with back ticks.")
    E match {
      case `pi` => println("strange math? Pi = "+ Pi)
      case _ => println("OK")
    }
  }
  def demo7 = demo("15.2.8 Variable binding") {
    BinOp("+", Var("x"), Var("y")) match {
      case BinOp("+", x @ Var(_), y @ Var(_)) => println("lhs: "+ x +", rhs: "+ y)
      case _ =>
    }
  }
  def demo8 = demo("15.3 Pattern guards") {
    def simplifyAdd(e: Expr): Expr = e match {
      case BinOp("+", x, y) if x == y => BinOp("*", x, Number(2))
      case _ => e
    }
    println(simplifyAdd(BinOp("+", Var("x"), Var("x"))))
    "alice" match {
      case s: String if s.startsWith("a") => println("Hi! "+ s)
      case _ => println("Go home!")
    }
  }
  def demo9 = demo("15.8 A larger example") {
    val f = new ExprFormatter
    val e1 = BinOp("*",
      BinOp("/", Number(1), Number(2)),
      BinOp("+", Var("x"), Number(1))
    )
    val e2 = BinOp("+",
      BinOp("/", Var("x"), Number(2)),
      BinOp("/", Number(1.5), Var("x"))
    )
    val e3 = BinOp("/", e1, e2)
    def show(e: Expr) { println(f.format(e) +"\n\n") }
    for (e <- Array(e1, e2, e3)) show(e)
  }

  demo1(); demo2(); demo3(); demo4(); demo5();
  demo6(); demo7(); demo8(); demo9();
}
