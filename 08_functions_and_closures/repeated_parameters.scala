def echo(args: String*) {
  for (arg <- args) {
    println(arg)
  }
}

echo()
echo("hoge")
echo("hoge", "piyo")

val args = Array("Hello",", ","World","!")
echo(args:_*)
