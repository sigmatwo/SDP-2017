package chain

case class MultNumbers() extends Chain {
  private var nextInChain: Chain = null

  override def setNextChain(nextChain: Chain) {
    nextInChain = nextChain
  }

  override def calculate(request: Numbers) {
    if (request.getCalcWanted eq "mult") {
      print(request.getNumber1 + " * " + request.getNumber2 + " = "
        + (request.getNumber1 * request.getNumber2))
    }
    else {
      nextInChain.calculate(request)
    }
  }
}
