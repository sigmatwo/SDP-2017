package decoratorpattern

class SimplyNonVegPizza extends Pizza {
  def getDesc: String = "SimplyNonVegPizza (350)"

  def getPrice: Double = 350
}
