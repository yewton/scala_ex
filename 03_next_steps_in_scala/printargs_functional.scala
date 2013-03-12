def printArgs(args: Array[String]): Unit = {
  for (arg <- args) println(arg)
}

def printArgs2(args: Array[String]): Unit = {
  args.foreach(println)
}

printArgs(Array("hoge", "piyo"))
printArgs2(Array("hoge", "piyo"))
