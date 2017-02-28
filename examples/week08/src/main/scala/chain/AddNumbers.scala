package chain

case class AddNumbers() extends Chain {
  private var nextInChain: Chain = null

  // Defines the next Object to receive the
  // data if this one can't use it
  override def setNextChain(nextChain: Chain) = {
    nextInChain = nextChain
  }

  // Tries to calculate the data, or passes it
  // to the Object defined in method setNextChain()
  override def calculate(request: Numbers) = {
    if (request.getCalcWanted eq "add") {
      print(request.getNumber1 + " + " + request.getNumber2 + " = " + (request.getNumber1 + request.getNumber2))
    } else {
      nextInChain.calculate(request)
    }
  }
}
