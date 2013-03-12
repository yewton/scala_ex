var assertionsEnabled = true
def myAssert(predicate: () => Boolean) =
  if (assertionsEnabled && !predicate())
    throw new AssertionError

try {
  myAssert(() => 3 > 5)
  // こうは書けない
  // myAssert(3 > 5)
} catch {
  case e: AssertionError =>
    println("ERROR: " + e)
}

// 名前渡しパラメータ
def byNameAssert(predicate: => Boolean) =
  if (assertionsEnabled && !predicate)
    throw new AssertionError

try {
  byNameAssert(3 > 5)
} catch {
  case e: AssertionError =>
    println("ERROR: " + e)
}

// 値渡しにすると…
def boolAssert(predicate: Boolean) =
  if (assertionsEnabled && !predicate)
    throw new AssertionError

assertionsEnabled = false

try {
  byNameAssert(1/0 == 0)
  println("By Name OK")
  boolAssert(1/0 == 0) // ここで例外が発生してしまう
  println("By Value OK")
} catch {
  case e: ArithmeticException =>
    println("Unexpected Exception: " + e)
}
