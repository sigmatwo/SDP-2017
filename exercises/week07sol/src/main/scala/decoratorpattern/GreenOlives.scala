package decoratorpattern

class GreenOlives(val pizza: Pizza) extends PizzaDecorator {
  override def getDesc: String = pizza.getDesc + ", Green Olives (5.47)"

  def getPrice: Double = pizza.getPrice + 5.47
}
