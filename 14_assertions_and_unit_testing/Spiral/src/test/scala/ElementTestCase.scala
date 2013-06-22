import junit.framework.TestCase
import junit.framework.Assert.assertEquals
import junit.framework.Assert.fail
import Element.elem

class ElementTestCase extends TestCase {
  def testUniformElement2() {
    val ele = elem('x', 2, 3)
    assertEquals(2, ele.width)
    assertEquals(3, ele.height)
    try {
      elem('x', -2, 3)
      fail("elem should throw an exception when given a negative number")
    } catch {
      case e: IllegalArgumentException => // 予想通り
    }
  }
}














