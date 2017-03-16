package state

class HasPin(var atmMachine: ATMMachine) extends ATMState {
  def insertCard() {
    System.out.println("You already entered a card")
  }

  def ejectCard() {
    System.out.println("Your card is ejected")
    atmMachine.setATMState(atmMachine.getNoCardState)
  }

  def requestCash(cashToWithdraw: Int) {
    if (cashToWithdraw > atmMachine.cashInMachine) {
      System.out.println("You don't have that much cash available")
      System.out.println("Your card is ejected")
      atmMachine.setATMState(atmMachine.getNoCardState)
    }
    else {
      System.out.println(cashToWithdraw + " is provided by the machine")
      atmMachine.setCashInMachine(atmMachine.cashInMachine - cashToWithdraw)
      System.out.println("Your card is ejected")
      atmMachine.setATMState(atmMachine.getNoCardState)
      if (atmMachine.cashInMachine <= 0) {
        atmMachine.setATMState(atmMachine.getNoCashState)
      }
    }
  }

  def insertPin(pinEntered: Int) {
    System.out.println("You already entered a PIN")
  }
}
