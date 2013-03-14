val someNumbers = List(-11, -10, -5, 0, 5, 10)

someNumbers.filter((x) => x > 0)
someNumbers.filter(x => x > 0)
someNumbers.filter(_ > 0)


val f = (_: Int) + (_: Int)
// f: (Int, Int) => Int = <function2>
f(5, 10)
