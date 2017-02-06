package first

object StringUtils {
    implicit class StringImprovements(val s: String) {
        def increment = s.map(c => (c + 1).toChar)
        def hideAll = s.replaceAll(".", "*")
    }
}
