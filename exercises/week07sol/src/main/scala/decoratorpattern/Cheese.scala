package decoratorpattern

class Cheese(val pizza: Pizza) extends PizzaDecorator {
  override def getDesc: String = pizza.getDesc + ", Cheese (20.72)"

  def getPrice: Double = pizza.getPrice + 20.72
}
