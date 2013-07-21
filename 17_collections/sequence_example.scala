// List
val colors = List("red", "blue", "green")
colors.head
colors.tail

// Array
val fiveInts = new Array[Int](5)
val fiveToOne = Array(5, 4, 3, 2, 1)
fiveInts(0) = fiveToOne(4)
fiveInts

// ListBuffer
// 要素の挿入が定数時間で処理出来る。
// 使いドコロ: リストの構築に必要な再帰アルゴリズムが末尾再帰でない場合
import scala.collection.mutable.ListBuffer
val buf = new ListBuffer[Int]
buf += 1
buf += 2
buf
3 +=: buf
buf.toList

// ArrayBuffer
// 先頭末尾で要素の追加・削除をサポートする配列
import scala.collection.mutable.ArrayBuffer
val buf = new ArrayBuffer[Int]()
buf += 12
15 +=: buf
buf

// StringOps
// String をシーケンスのように扱うためのラッパー
"hello World".exists(_.isUpper)
