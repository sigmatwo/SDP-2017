package decoratorpattern

class Meat(val pizza: Pizza) extends PizzaDecorator {
  override def getDesc: String = pizza.getDesc + ", Meat (14.25)"

  def getPrice: Double = pizza.getPrice + 14.25
}
