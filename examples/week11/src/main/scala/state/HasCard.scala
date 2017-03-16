package state

class HasCard(var atmMachine: ATMMachine) extends ATMState {
  override def insertCard() = println("You can only insert one card at a time")

  override def ejectCard() {
    println("Your card is ejected")
    atmMachine.setATMState(atmMachine.getNoCardState)
  }

  override def requestCash(cashToWithdraw: Int) = println("You have not entered your PIN")

  override def insertPin(pinEntered: Int) {
    if (pinEntered == 1234) {
      println("You entered the correct PIN")
      atmMachine.correctPinEntered = true
      atmMachine.setATMState(atmMachine.getHasPin)
    }
    else {
      println("You entered the wrong PIN")
      atmMachine.correctPinEntered = false
      println("Your card is ejected")
      atmMachine.setATMState(atmMachine.getNoCardState)
    }
  }
}
