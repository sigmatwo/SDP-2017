package cats

// Lions -> Antelope
// Tigers -> Tiger food
// Panthers -> Licorice
// Cats -> Mice

sealed trait Food
final case object Antelope extends Food
final case object TigerFood extends Food
final case object Licorice extends Food
final case class Mice() extends Food