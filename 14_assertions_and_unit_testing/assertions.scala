def foo(a: Int, b: Int): Int = {
  assert(a <= b, "assert")
  a + b
} ensuring(a < _, "ensuring")

foo(1, 2) // res6: Int = 3
foo(2, 1) // java.lang.AssertionError: assertion failed: assert
foo(0, 0) // java.lang.AssertionError: assertion failed: ensuring
