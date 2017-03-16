package decoratorpattern

class RedOnions(val pizza: Pizza) extends PizzaDecorator {
  override def getDesc: String = pizza.getDesc + ", Red Onions (3.75)"

  def getPrice: Double = pizza.getPrice + 3.75
}
