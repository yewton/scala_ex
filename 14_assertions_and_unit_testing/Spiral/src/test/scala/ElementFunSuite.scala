import org.scalatest.FunSuite
import Element.elem

class ElementFunSuite extends FunSuite {
  test("elem result should have passed width") {
    val ele = elem('x', 2, 3)
    expectResult(2) {
      ele.width
    }
  }

  // This test will be failed
  test("elem should throw an exception when given a negative number") {
    intercept[IllegalArgumentException] {
      elem('x', -2, 3)
    }
  }
}
