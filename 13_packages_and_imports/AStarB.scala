import java.util.regex

object AStarB extends App {
  val pat = regex.Pattern.compile("a*b")
  println(pat.matcher("aaaaaaaaaaaaaab").matches)
  println(pat.matcher("baaaaaaaaaaaaaa").matches)
}
