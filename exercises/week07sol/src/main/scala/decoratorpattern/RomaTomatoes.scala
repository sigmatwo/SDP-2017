package decoratorpattern

class RomaTomatoes(val pizza: Pizza) extends PizzaDecorator {
  override def getDesc: String = pizza.getDesc + ", Roma Tomatoes (5.20)"

  def getPrice: Double =  pizza.getPrice + 5.20
}
