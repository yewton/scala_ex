object FileMatcher {
  private def filesHere = (new java.io.File(".")).listFiles
  def filesEnding(query: String) =
    for (
      file <- filesHere;
      if file.getName.endsWith(query)
    ) yield file
  def filesContaining(query: String) =
    for (
      file <- filesHere;
      if file.getName.contains(query)
    ) yield file
  def filesRegex(query: String) =
    for (
      file <- filesHere;
      if file.getName.matches(query)
    ) yield file
}

FileMatcher.filesEnding("ze.scala").foreach(println)
FileMatcher.filesContaining("file").foreach(println)
FileMatcher.filesRegex(".+Summer.+scala$").foreach(println)

object FileMatcher2 {
  private def filesHere = (new java.io.File(".")).listFiles
  private def filesMatching(matcher: String => Boolean) =
    for (file <- filesHere; if matcher(file.getName)) yield file
  def filesEnding(query: String) =
    filesMatching(_.endsWith(query))
  def filesContaining(query: String) =
    filesMatching(_.contains(query))
  def filesRegex(query: String) =
    filesMatching(_.matches(query))
}

FileMatcher2.filesEnding("ze.scala").foreach(println)
FileMatcher2.filesContaining("file").foreach(println)
FileMatcher2.filesRegex(".+Summer.+scala$").foreach(println)
