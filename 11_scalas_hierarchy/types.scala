def print(a: Any) { println(a.getClass) }
print("hoge")
// class java.lang.String
print(42)
// class java.lang.Integer
def printval(a: AnyVal) { println(a.getClass) }
printval(42)
//class java.lang.Integer
printval("hoge")
// class scala.collection.immutable.StringOps
def printref(a: AnyRef) { println(a.getClass)}
// printref(42) => error: type mismatch;
printref("hoge")
// class java.lang.String
