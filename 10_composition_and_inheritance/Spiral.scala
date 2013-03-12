import Element.elem

object Direction {
  val UP_VAL    = 1
  val DOWN_VAL  = 3
  val RIGHT_VAL = 2
  val LEFT_VAL  = 0
  val up    = Direction(UP_VAL)
  val down  = Direction(DOWN_VAL)
  val left  = Direction(LEFT_VAL)
  val right = Direction(RIGHT_VAL)
}

case class Direction private (
  val d: Int
) {
  import Direction._
  def next(): Direction =
    ((d + 3) % 4) match {
      case UP_VAL    => up
      case DOWN_VAL  => down
      case RIGHT_VAL => right
      case LEFT_VAL  => left
    }
  override def toString =
    d match {
      case UP_VAL    => "UP"
      case DOWN_VAL  => "DOWN"
      case RIGHT_VAL => "RIGHT"
      case LEFT_VAL  => "LEFT"
      case _     => throw new IllegalArgumentException
    }
}

object Spiral {
  val space = elem(" ")
  val corner = elem("+")
  def spiral(nEdges: Int, direction: Direction): Element = {
    if (nEdges == 1)
      elem("+")
    else {
      val sp = spiral(nEdges - 1, direction.next())
      def verticalBar = elem('|', 1, sp.height)
      def horizonalBar = elem('-', sp.width, 1)
      direction match {
        case Direction.left  =>
          (corner beside horizonalBar) above (sp beside space)
        case Direction.up    =>
          (sp above space) beside (corner above verticalBar)
        case Direction.right =>
          (space beside sp) above (horizonalBar beside corner)
        case Direction.down  =>
          (verticalBar above corner) beside (space above sp)
      }
    }
  }
  def main(args: Array[String]) {
    val nSides = args(0).toInt
    println(spiral(nSides, Direction.left))
  }
}
