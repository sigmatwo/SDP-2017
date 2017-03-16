package proxy

// In this situation the proxy both creates and destroys
// an ATMMachine Object
case class ATMProxy() extends GetATMData {
  // Allows the user to access getATMState in the Object ATMMachine

  override def getATMState: ATMState = ATMMachine().getATMState

  // Allows the user to access getCashInMachine
  // in the Object ATMMachine
  override def getCashInMachine: Int = ATMMachine().getCashInMachine
}
