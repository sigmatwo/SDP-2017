package interpreter

class Quarts extends Expression {
  override def gallons(quantity: Double): String = String.valueOf(quantity / 4)

  override def quarts(quantity: Double): String = String.valueOf(quantity)

  override def pints(quantity: Double): String = String.valueOf(quantity * 2)

  override def cups(quantity: Double): String = {
    return Double.toString(quantity * 4)
  }

  override def tablespoons(quantity: Double): String = {
    return Double.toString(quantity * 64)
  }
}
