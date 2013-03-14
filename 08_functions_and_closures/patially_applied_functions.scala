def sum(a: Int, b: Int, c: Int) = a + b + c
val a = sum _
// a: (Int, Int, Int) => Int = <function3>
a(1, 2, 3) // a.apply(1, 2, 3)
// res64: Int = 6
val b = sum(1, _: Int, 3)
// b: Int => Int = <function1>
b(2)
// res65: Int = 6
