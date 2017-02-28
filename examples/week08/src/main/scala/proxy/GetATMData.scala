package proxy

// This interface will contain just those methods
// that you want the proxy to provide access to
trait GetATMData {
  def getATMState: ATMState

  def getCashInMachine: Int
}
