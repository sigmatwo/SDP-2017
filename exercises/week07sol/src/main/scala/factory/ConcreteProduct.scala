package factory

class ConcreteProduct(var str: String) extends Product {
  def getThing: String = "[" + str + "] " + getClass.getName
}
