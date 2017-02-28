package chain

// This object will contain 2 numbers and a
// calculation to perform in the form of a String
case class Numbers(var number1: Int, var number2: Int, var calculationWanted: String) {
  def getNumber1: Int = number1

  def getNumber2: Int = number2

  def getCalcWanted: String = calculationWanted
}
