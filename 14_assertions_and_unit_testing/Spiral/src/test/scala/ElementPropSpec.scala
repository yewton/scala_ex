import org.scalatest.WordSpec
import org.scalatest.prop.Checkers
import org.scalacheck.Prop._
import Element.elem

class ElementPropSpec extends WordSpec with Checkers {
  "elem result" must {
    "have passed width" in {
      // cf. http://pastebin.com/SmLqqawn
      forAll { w: Int =>
        (w > 0 && w < 80) ==> (elem('x', w, 3).width == w)
      }
      // check((w: Int) => w > 0 ==> (elem('x', w, 3).width == w))
    }
    "have passed height" in {
      check((h: Int) => h > 0 ==> (elem('x', 2, h).height == h))
    }
  }
}
