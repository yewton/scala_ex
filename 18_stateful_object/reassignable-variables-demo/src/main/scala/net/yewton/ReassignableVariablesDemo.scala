package net.yewton
import scala.util.{Try, Success, Failure}
import net.yewton.exercise.{Time, Thermometer}

object ReassignableVariablesDemo extends App {
  def formatTime(t: Time): String = {
    "%02d:%02d".format(t.hour, t.minute)
  }

  val t = new Time
  println("It's time %02d:%02d.".format(t.hour, t.minute))

  t.hour = 3
  t.minute = 55
  println("Now it's time %02d:%02d.".format(t.hour, t.minute))

  Try {
    t.hour = 24
    t.minute = 60
  } match {
    case Success(_) => sys.error("!?")
    case Failure(e) => println(s"Strange values are not assignable: $e")
  }

  val thermo = new Thermometer
  println(s"It's temperature $thermo")

  thermo.celsius = 100
  println(s"Now $thermo")

  thermo.fahrenheit = -40
  println(s"Now $thermo")
}
















