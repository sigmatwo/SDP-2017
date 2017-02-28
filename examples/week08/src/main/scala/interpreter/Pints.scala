package interpreter

class Pints extends Expression {
  def gallons(quantity: Double): String = {
    return Double.toString(quantity / 8)
  }

  def quarts(quantity: Double): String = {
    return Double.toString(quantity / 2)
  }

  def pints(quantity: Double): String = {
    return Double.toString(quantity)
  }

  def cups(quantity: Double): String = {
    return Double.toString(quantity * 2)
  }

  def tablespoons(quantity: Double): String = {
    return Double.toString(quantity * 32)
  }
}
