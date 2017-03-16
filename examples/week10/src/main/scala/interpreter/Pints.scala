package interpreter

final case class Pints() extends Expression {
  override def gallons(quantity: Double) = (quantity / 8).toString

  override def quarts(quantity: Double)= (quantity / 2).toString

  override def pints(quantity: Double) = quantity.toString

  override def cups(quantity: Double) = (quantity * 2).toString

  override def tablespoons(quantity: Double)= (quantity * 32).toString
}
