package p {
  class Outer {
    protected def f() {
      println("f")
      (new Inner).h
    }
    class Inner {
      private def g() { println ("g") }
      def h() { (new InnerMost) }
      class InnerMost {
        g() // OK!
      }
    }
    // (new Inner).g() Error!
    def i() {
      f()
    }
  }
  class Sub extends Outer {
    f()
  }
  class Other {
    // (new Outer).f() Error!
  }
  object AccessModifiersDemo extends App {
    (new Outer).i
    (new Sub)
  }
}
// $ scala p.AccessModifiersDemo
// f
// g
// f
// g
