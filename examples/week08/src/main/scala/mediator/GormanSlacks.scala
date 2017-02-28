package mediator

case class GormanSlacks(val newMediator: Mediator) extends Colleague(newMediator) {
  println("Gorman Slacks signed up with the stockexchange\n")
}
