package cats

// Feline at root and Lion, Tiger, Panther, and Cat as sub-types

// add a method "dinner" ->
// Lions -> Antelope
// Tigers -> Tiger food
// Panthers -> Licorice
// Cats -> Mice

// you should implement the food as a sealed trait and case object

// Start by using polymorphism

sealed trait Feline {
    def dinner: Food
}

final case class Lion() extends Feline {
    def dinner: Food = Antelope
}

final case class Tiger() extends Feline {
    def dinner: Food = TigerFood
}

final case class Panther() extends Feline {
    def dinner: Food = Licorice
}

final case class Cat() extends Feline {
    def dinner: Food = Mice()
}
