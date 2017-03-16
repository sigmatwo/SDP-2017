package decoratorpattern

class FetaCheese(val pizza: Pizza) extends PizzaDecorator {
  override def getDesc: String = pizza.getDesc + ", Feta Cheese (25.88)"

  def getPrice: Double = pizza.getPrice + 25.88
}
