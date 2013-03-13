// cf. http://eed3si9n.com/ja/node/15
object AddressPrinter extends App {
  // def printLabel[T](t: T)(implicit lm: LabelMaker[T]) { println(lm.toLabel(t)) }
  def printLabel[T: LabelMaker](t: T) { println(implicitly[LabelMaker[T]].toLabel(t)) } // context bound
  printLabel(Address(100, "Monroe Street", "Denver", "CO", "80231"))
}
