package second

package object utils {
    implicit class StringImprovements(val s: String) {
        def increment = s.map(c => (c + 1).toChar)
        def hideAll = s.replaceAll(".", "*")
        def plusOne = s.toInt + 1
        def asBoolean = s match {
            case "0" | "zero" | "" | " " => false
            case _ => true
        }
    }
}