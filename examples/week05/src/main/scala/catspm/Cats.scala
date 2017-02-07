package catspm

import cats._

// Lions -> Antelope
// Tigers -> Tiger food
// Panthers -> Licorice
// Cats -> Mice

sealed trait Feline {
    def dinner: Food =
        this match {
            case Lion() => Antelope
            case Tiger() => TigerFood
            case Panther() => Licorice
            case Cat() => Mice()
        }
}

final case class Lion() extends Feline 
final case class Tiger() extends Feline
final case class Panther() extends Feline
final case class Cat() extends Feline 

object Dinner {
    def dinner(feline: Feline): Food =
        feline match {
            case Lion() => Antelope
            case Tiger() => TigerFood
            case Panther() => Licorice
            case Cat() => Mice()
        }
}
