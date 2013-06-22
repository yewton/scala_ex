import org.scalatest.testng.TestNGSuite
import org.testng.annotations.Test
import Element.elem

class ElementTests extends TestNGSuite {
  @Test def verifyUniformElement() {
    val ele = elem('x', 2, 3)
    assert(ele.width === 2)
    expectResult(3) { ele.height }
    intercept[IllegalArgumentException] {
      elem('x', -2, 3)
    }
  }
}
