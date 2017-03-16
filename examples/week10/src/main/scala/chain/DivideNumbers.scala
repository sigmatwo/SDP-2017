package chain

case class DivideNumbers() extends Chain {
  private var nextInChain: Chain = null

  override def setNextChain(nextChain: Chain) {
    nextInChain = nextChain
  }

  override def calculate(request: Numbers) {
    if (request.getCalcWanted eq "div") {
      print(request.getNumber1 + " / " + request.getNumber2 + " = "
        + (request.getNumber1 / request.getNumber2))
    }
    else {
      print("Only works for add, sub, mult, and div")
    }
  }
}
