package state

case class ATMMachine() {
  if (cashInMachine < 0) {
    atmState = atmOutOfMoney
  }
  private[state] var hasCard: ATMState = null
  private[state] var noCard: ATMState = null
  private[state] var hasCorrectPin: ATMState = null
  private[state] var atmOutOfMoney: ATMState = null
  private[state] var atmState: ATMState = null
  private[state] var cashInMachine: Int = 0
  private[state] var correctPinEntered: Boolean = false

  private[state] def setATMState(newATMState: ATMState) {
    atmState = newATMState
  }

  def setCashInMachine(newCashInMachine: Int) {
    cashInMachine = newCashInMachine
  }

  def insertCard() {
    atmState.insertCard()
  }

  def ejectCard() {
    atmState.ejectCard()
  }

  def requestCash(cashToWithdraw: Int) {
    atmState.requestCash(cashToWithdraw)
  }

  def insertPin(pinEntered: Int) {
    atmState.insertPin(pinEntered)
  }

  def getYesCardState: ATMState = {
    return hasCard
  }

  def getNoCardState: ATMState = {
    return noCard
  }

  def getHasPin: ATMState = {
    return hasCorrectPin
  }

  def getNoCashState: ATMState = {
    return atmOutOfMoney
  }
}
