package proxy

// In this situation the proxy both creates and destroys
// an ATMMachine Object
class ATMProxy extends GetATMData {
  // Allows the user to access getATMState in the
  // Object ATMMachine
  override def getATMState: ATMState = {
    val realATMMachine: ATMMachine = ATMMachine()
    realATMMachine.getATMState
  }

  // Allows the user to access getCashInMachine
  // in the Object ATMMachine
  override def getCashInMachine: Int = {
    val realATMMachine: ATMMachine = ATMMachine()
    realATMMachine.getCashInMachine
  }
}
