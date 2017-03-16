package proxy

trait ATMState {
  def insertCard()

  def ejectCard()

  def insertPin(pinEntered: Int)

  def requestCash(cashToWithdraw: Int)
}
