package proxy

object TestATMMachine extends App {
  val atmMachine = ATMMachine()
  atmMachine.insertCard()
  atmMachine.ejectCard()
  atmMachine.insertCard()
  atmMachine.insertPin(1234)
  atmMachine.requestCash(2000)
  atmMachine.insertCard()
  atmMachine.insertPin(1234)

  // Proxy Design Pattern Code
  // The interface limits access to just the methods you want made accessible

  val realATMMachine: GetATMData = ATMMachine()
  val atmProxy: GetATMData = new ATMProxy
  println("\nCurrent ATM State " + atmProxy.getATMState)
  println("\nCash in ATM Machine $" + atmProxy.getCashInMachine)
  // The user can't perform this action because ATMProxy doesn't
  // have access to that potentially harmful method

  // atmProxy.setCashInMachine(10000);
}
