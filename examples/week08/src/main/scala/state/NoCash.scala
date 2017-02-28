package state

class NoCash(var atmMachine: ATMMachine) extends ATMState {
  def insertCard() {
    System.out.println("We don't have any money")
    System.out.println("Your card is ejected")
  }

  def ejectCard() {
    System.out.println("We don't have any money")
    System.out.println("There is no card to eject")
  }

  def requestCash(cashToWithdraw: Int) {
    System.out.println("We don't have any money")
  }

  def insertPin(pinEntered: Int) {
    System.out.println("We don't have any money")
  }
}
