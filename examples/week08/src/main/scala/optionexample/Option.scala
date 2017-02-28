sealed trait Option[+A] {
    def getOrElse(default: A): A
    def isEmpty: Boolean
    def isDefined: Boolean = !isEmpty
    // whole lot of other methods...
}

final case class Some[A](x: A) extends Option[A]{
    def getOrElse(default: A) = x
    def isEmpty = false
    // other methods...
}

final case object None extends Option[Nothing] {
    def getOrElse(default: Nothing) = default

    def isEmpty = true
    // other methods...
}