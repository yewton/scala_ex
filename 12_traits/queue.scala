abstract class IntQueue {
  def get(): Int
  def put(x: Int)
}

import scala.collection.mutable.ArrayBuffer

class BasicIntQueue extends IntQueue {
  private val buf = new ArrayBuffer[Int]
  def get() = buf.remove(0)
  def put(x: Int) { buf += x }
}

val queue = new BasicIntQueue
queue.put(10)
queue.put(20)
queue.get()
queue.get()

trait Doubling extends IntQueue { // Doubling をミックスイン出来るのは IntQueue の派生クラスだけ
  // abstract 修飾子は、put の具象定義を持つクラスにミックスインしなければならないことを表す
  abstract override def put(x: Int) { super.put(2 * x) } // この super の呼び出しは動的に束縛される
}

class MyQueue extends BasicIntQueue with Doubling

val queue2 = new MyQueue
queue2.put(10)
queue2.get()

trait Incrementing extends IntQueue {
  abstract override def put(x: Int) { super.put(x + 1) }
}

trait Filtering extends IntQueue {
  abstract override def put(x: Int) {
    if (x >= 0) super.put(x)
  }
}

val queue3 = (new BasicIntQueue with Incrementing with Filtering)
queue3.put(-1)
queue3.put(0)
queue3.put(1)
queue3.get()
queue3.get()

val queue4 = (new BasicIntQueue with Filtering with Incrementing)
queue4.put(-1)
queue4.put(0)
queue4.put(1)
queue4.get()
queue4.get()
queue4.get()
