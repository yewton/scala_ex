import org.scalatest.junit.JUnit3Suite
import Element.elem

class ElementJUnit3Suite extends JUnit3Suite {
  def testUniformElement3() {
    val ele = elem('x', 2, 3)
    assert(ele.width === 2)
    expectResult(3) { ele.height }
    intercept[IllegalArgumentException] {
      elem('x', -1, 3)
    }
  }
}
