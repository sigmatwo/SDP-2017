package state

case class NoCard(var atmMachine: ATMMachine) extends ATMState {
  override def insertCard() {
    println("Please enter your pin")
    atmMachine.setATMState(atmMachine.getYesCardState)
  }

  override def ejectCard() = println("You didn't enter a card")

  override def requestCash(cashToWithdraw: Int) =
    println("You have not entered your card")

  override def insertPin(pinEntered: Int) =
    println("You have not entered your card")
}
