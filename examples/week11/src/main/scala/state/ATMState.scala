package state

trait ATMState {
  // Different states expected
  // HasCard, NoCard, HasPin, NoCash
  def insertCard()

  def ejectCard()

  def insertPin(pinEntered: Int)

  def requestCash(cashToWithdraw: Int)
}
