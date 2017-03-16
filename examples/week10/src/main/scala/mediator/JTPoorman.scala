package mediator

case class JTPoorman(val newMediator: Mediator) extends Colleague(newMediator) {
  println("JT Poorman signed up with the stockexchange\n")
}
