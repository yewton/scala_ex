package net.yewton.simulation

abstract class Simulation {
  type Action = () => Unit
  case class WorkItem(time: Int, action: Action)
  private[this] var curtime = 0
  def currentTime: Int = curtime
  private[this] var agenda: List[WorkItem] = List()
  private[this] def insert(
    ag: List[WorkItem],
    item: WorkItem
  ): List[WorkItem] = {
    if (ag.isEmpty || item.time < ag.head.time) item :: ag
    else ag.head :: insert(ag.tail, item)
  }
  def afterDelay(delay: Int)(block: => Unit) {
    val item = WorkItem(currentTime + delay, () => block)
    agenda = insert(agenda, item)
  }
  private[this] def next() {
    (agenda: @unchecked) match {
      case item :: rest =>
        agenda = rest
        curtime = item.time
        item.action()
    }
  }
  def run() {
    afterDelay(0) {
      println(s"*** simulation started, time = $currentTime ***")
    }
    while (!agenda.isEmpty) next()
  }
}
