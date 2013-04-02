import scala.language.implicitConversions

class Rational(n: Int, d: Int) extends Ordered[Rational] {
  require(d != 0)
  private val g = gcd(n.abs, d.abs)
  val numer: Int = n / g // Numerator
  val denom: Int = d / g // Denominator

  override def toString = this.numer +"/"+ denom

  def this(n: Int) = this(n, 1)

  def + (that: Rational): Rational =
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )
  def + (i: Int): Rational =
    new Rational(numer + i * denom, denom)

  def - (that: Rational): Rational =
    new Rational(
      numer * that.denom - that.numer * denom,
      denom * that.denom
    )
  def - (i: Int): Rational =
    new Rational(numer + i * denom, denom)

  def * (that: Rational): Rational =
    new Rational(
      numer * that.numer, denom * that.denom
    )
  def * (i: Int): Rational =
    new Rational(numer * i, denom)

  def / (that: Rational): Rational =
    new Rational(numer * that.denom, denom * that.numer)
  def / (i: Int): Rational =
    new Rational(numer, denom * i)

  def lessThan(that: Rational) =
    this.numer * that.denom < that.numer * denom

  def max(that: Rational) =
    if (this lessThan that) that else this

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b) // Euclidian

  def compare(that: Rational) =
    (this.numer * that.denom) - (that.numer * this.denom)
}

val a = new Rational(66, 42)
val b = new Rational(2, 3)
val c = a + b
println(c.denom)
println(a.max(b))
val d = new Rational(5)
println(d)
println(a + b * c)
val x = new Rational(2, 3)
println(x * x)
println(x * 2)
implicit def intToRational(x: Int) = new Rational(x)
val r = new Rational(2, 3)
println(2 * r)
val half = new Rational(1, 2)
val third = new Rational(1, 3)
half < third
half > third
