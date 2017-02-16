// <: 
// >:

trait Animal
trait Cat extends Animal
trait Dog extends Animal
case class Siamese(name: String) extends Cat
case class Sheltie(name: String) extends Dog

// invariant
sealed trait LinkedList[+A]
final case class Node[A](value: A, next: LinkedList[A]) extends LinkedList[A]
//final case class End[A]() extends LinkedList[A]
final case object End extends LinkedList[Nothing]

// Covariant Generic Sum Type Pattern
//
// sealed trait A[+T]
// final case class B[T](t: T) extends A[T]
// final case object C extends A[Nothing]


object LLMain extends App {
    val l = Node(Siamese("Fred"), 
                Node(Sheltie("Robbie"),
                       Node(Siamese("Bertie"),End)))
    println(l)

    val l2 = Node(3,Node(4,End))
    println(l2)
}