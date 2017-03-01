package proxy

case class ATMMachine() extends GetATMData with ATMState {
  private val hasCard: ATMState = null
  private val noCard: ATMState = null
  private val hasCorrectPin: ATMState = null
  private val atmOutOfMoney: ATMState = null
  private val atmState: ATMState = null
  private val cashInMachine: Int = 0

  def getYesCardState: ATMState = hasCard

  def getNoCardState: ATMState = noCard

  def getHasPin: ATMState = hasCorrectPin

  def getNoCashState: ATMState = atmOutOfMoney

  // NEW STUFF
  override def getATMState: ATMState = atmState

  override def getCashInMachine: Int = cashInMachine

  override def insertCard() = println("inserting card")

  override def ejectCard() = println("ejecting card")

  override def insertPin(pinEntered: Int) = println(s"Pin entered $pinEntered")

  override def requestCash(cashToWithdraw: Int) = println(s"Cash to withdraw $cashToWithdraw")
}
