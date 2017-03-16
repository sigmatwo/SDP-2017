package decoratorpattern

class Broccoli(val pizza: Pizza) extends PizzaDecorator {
  override def getDesc: String = pizza.getDesc + ", Broccoli (9.25)"

  def getPrice: Double = pizza.getPrice + 9.25
}
