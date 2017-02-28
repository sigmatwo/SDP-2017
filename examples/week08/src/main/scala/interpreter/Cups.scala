package interpreter

class Cups extends Expression {
  def gallons(quantity: Double): String = {
    return Double.toString(quantity / 16)
  }

  def quarts(quantity: Double): String = {
    return Double.toString(quantity / 4)
  }

  def pints(quantity: Double): String = {
    return Double.toString(quantity / 2)
  }

  def cups(quantity: Double): String = {
    return Double.toString(quantity)
  }

  def tablespoons(quantity: Double): String = {
    return Double.toString(quantity * 16)
  }
}
