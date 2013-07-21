val fruit: List[String] = List("apples", "oranges", "pears")
val nums: List[Int] = List(1, 2, 3, 4)
val diag3: List[List[Int]] =
  List(
    List(1, 0, 0),
    List(0, 1, 0),
    List(0, 0, 1)
  )
val empty: List[Nothing] = List()
// ・Nothing はあらゆる型のサブ型
// ・リストは共変
val xs: List[String] = List()

// リストの作り方
val l = "apples" :: ("oranges" :: ("pears" :: Nil))

// 挿入ソート
def insert(x: Int, xs: List[Int]): List[Int] = {
  if (xs.isEmpty || x <= xs.head) x :: xs
  else xs.head :: insert(x, xs.tail)
}
def isort(xs: List[Int]): List[Int] = {
  if (xs.isEmpty) Nil
  else insert(xs.head, isort(xs.tail))
}
val ns: List[Int] = List(10, 8, 9, 7, 1, 2, 5, 4, 6, 3)
isort(ns)

// ::: (連結) を実装してみる
def append[T](xs: List[T], ys: List[T]): List[T] = {
  xs match {
    case Nil => ys
    case x :: xs1 => x :: append(xs1, ys)
  }
}
append(List(1, 2, 3), List(4, 5, 6))

// マージソート O(n log(n))
def msort[T](less: (T, T) => Boolean)(xs: List[T]): List[T] = {
  def merge(xs: List[T], ys: List[T]): List[T] = {
    (xs, ys) match {
      case (Nil, _) => ys
      case (_, Nil) => xs
      case (x :: xs1, y :: ys1) => {
        if (less(x, y)) {
          x :: merge(xs1, ys)
        } else y :: merge(xs, ys1)
      }
    }
  }
  val n = xs.length / 2
  if (n == 0) {
    xs
  } else {
    val (ys, zs) = xs splitAt n
    merge(msort(less)(ys), msort(less)(zs))
  }
}
val intSort = msort((x: Int, y: Int) => x < y) _
intSort(List(4, 1, 8, 9, 7, 3, 2, 6, 5))

// map, flatMap
((1 to 5) flatMap {
  i => (1 to i) map (j => (i, j))
}).foreach(println)
// for で同じ事をする
(for {
  i <- 1 to 5
  j <- 1 to i
} yield (i, j)).foreach(println)

// フィルタリング
val p: Int => Boolean = _ % 2 == 0
(1 to 5) filter p
(1 to 5) partition p
(1 to 5) find p

List(1, 2, 3, -4, 5) takeWhile (_ > 0) // => List(1, 2, 3)
List(1, 2, 3, -4, 5) dropWhile (_ > 0) // => List(-4, 5)
List(1, 2, 3, -4, 5) span (_ > 0)      // => (List(1, 2, 3),List(-4, 5))

// 述語関数
(1 to 5) forall (_ > 3) // => false
(1 to 5) exists (_ < 3) // => true

// 左畳み込み
(0 /: (1 to 10))(_ + _) // => 55
(1 /: (1 to 5))(_ * _)  // => 120
// 以下と同じ
(1 to 10)./:(0)(_ + _)
(1 to 10).foldLeft(0)(_ + _)
(1 to 5)./:(1)(_ * _)
(1 to 5).foldLeft(1)(_ * _)
// 右畳込み
((1 to 10) :\ 0)(_ + _) // => 55
(1 to 10).foldRight(0)(_ + _)

// 結合則が成り立つ演算では右畳込みでも左畳込みでも結果は同じ
// しかし効率に差が出る場合がある
def flattenLeft[T](xss: List[List[T]]) = {
  (List[T]() /: xss) (_ ::: _) // (((Nil ::: l1) ::: l2) ::: l3) ... でかいリストへの append は効率が悪い
}
def flattenRight[T](xss: List[List[T]]) = {
  (xss :\ List[T]()) (_ ::: _) // (Nil ::: (l1 ::: (l2 ::: l3))) ... 小さいリストへの append になって効率がいい
}
// ちなみに List[T]() でなく Nil や List() ではコンパイルエラー
// ∵ Scala はリストの要素型を型推論することができない

// 参考: 線形時間で終わる reverse
def reverse[T](xs: List[T]): List[T] = (Nil /: xs) {(ys: List[T], y: T) => y :: ys }

// ソート
List(1, -3, 4, 2, 6) sortWith(_ < _) // 実装はマージソート

// ファクトリメソッドたち
List.apply(1, 2, 3)
List(1, 2, 3)
List.range(1, 5)    // => List(1, 2, 3, 4)
List.range(1, 9, 2) // => List(1, 3, 5, 7)
List.fill(5)('a')   // => List(a, a, a, a, a)
List.fill(2, 3)(0)  // => List(List(0, 0, 0), List(0, 0, 0))
((List.tabulate(5, 5) { (y: Int, x: Int) =>
  "(%2d,%2d)".format(x, y)
}).map { row =>
  row.mkString(", ")
}).mkString("\n")
List.concat(List('a', 'b'), List('c'))
List('a', 'b') ::: List('c')
(List(1, 2, 3), List(4, 5)).zipped.map {(x, y) => x * y}     // => List(4, 10)
(List("abc", "de"), List(3, 2)).zipped.forall(_.length == _) // => true
(List("abc", "de"), List(3, 2)).zipped.exists(_.length != _) // => false

// 参考: Scala の型推論
// msort(_ > _)(List(1, 3, 2))
//   => error: missing parameter type for expanded function ((x$1, x$2) => x$1.$greater(x$2))
// type (T, T) => Boolean 型の型推論を _ > _ に対してやるのはムリ
msort[Int](_ > _)(List(1, 3, 2)) // OK
def msortSwapped[T](xs: List[T])(less: (T, T) => Boolean): List[T] = msort(less)(xs)
msortSwapped(List(1, 3, 2))(_ > _) // 逆にすれば型推論できる
