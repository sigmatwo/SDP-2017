package decoratorpattern

trait PizzaDecorator extends Pizza {
  def getDesc: String = "Toppings"
}
