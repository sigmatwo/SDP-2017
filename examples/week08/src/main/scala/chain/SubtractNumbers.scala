package chain

case class SubtractNumbers() extends Chain {
  private var nextInChain: Chain = null

  def setNextChain(nextChain: Chain) {
    nextInChain = nextChain
  }

  def calculate(request: Numbers) {
    if (request.getCalcWanted eq "sub") {
      System.out.print(request.getNumber1 + " - " + request.getNumber2 + " = " + (request.getNumber1 - request.getNumber2))
    }
    else {
      nextInChain.calculate(request)
    }
  }
}
