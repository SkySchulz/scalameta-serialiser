package mp

import scala.annotation.compileTimeOnly
import scala.meta._

@compileTimeOnly("@mp.Main not expanded")
class Main extends scala.annotation.StaticAnnotation {
  // import autocomplete._
  inline def apply(defn: Any): Any = meta {
    val q"object $name { ..$stats }" = defn
    val main = q"def banana(args: Array[String]): Unit = { ..$stats }"
    q"object $name { $main }"
  }
}
