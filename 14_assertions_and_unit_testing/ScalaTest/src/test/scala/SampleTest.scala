import org.scalatest.Suite

class SampleTest extends Suite {
  def testSuccess() {
    assert(1 == 1)
  }

  def testFail() {
    assert(1 == 0)
  }
}
