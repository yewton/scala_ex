import java.sql.{Date => SDate}
import java.{sql => S}
import java.util.Date

val now = new Date
val nnow = new SDate(now.getTime)
val nnnow = new S.Date(nnow.getTime)
println(now)
println(nnow)
println(nnnow)


