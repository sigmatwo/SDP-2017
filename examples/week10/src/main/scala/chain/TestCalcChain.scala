package chain

object TestCalcChain extends App {
  // Here I define all of the objects in the chain
  val chainCalc1: Chain = AddNumbers()
  val chainCalc2: Chain = SubtractNumbers()
  val chainCalc3: Chain = MultNumbers()
  val chainCalc4: Chain = DivideNumbers()
  // Here I tell each object where to forward the
  // data if it can't process the request
  chainCalc1.setNextChain(chainCalc2)
  chainCalc2.setNextChain(chainCalc3)
  chainCalc3.setNextChain(chainCalc4)
  // Define the data in the Numbers Object
  // and send it to the first Object in the chain
  chainCalc1.calculate(Numbers(4, 2, "add"))
}
