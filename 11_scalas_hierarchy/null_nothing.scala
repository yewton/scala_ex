val n: Null = null
// val i: Int = null => error: type mismatch;
val s: String = null

def error(message: String): Nothing =
  throw new RuntimeException(message)

def divide(x: Int, y: Int): Int =
  if (y != 0) x / y else error("can't divide by zero")

try {
  println(divide(4, 2))
  println(divide(4, 0))
} catch {
  case e: RuntimeException =>
    println(e)
}
