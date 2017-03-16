package decoratorpattern

class Chicken(val pizza: Pizza) extends PizzaDecorator {
  override def getDesc: String = pizza.getDesc + ", Chicken (12.75)"

  def getPrice: Double = pizza.getPrice + 12.75
}
