trait LabelMaker[T] {
  def toLabel(value: T): String
}

object LabelMaker {
  implicit object AddressLabelMaker extends LabelMaker[Address] {
    def toLabel(address: Address): String = {
      import address._
      "%d %s, %s, %s - %s".format(no, street, city, state, zip)
    }
  }
}

