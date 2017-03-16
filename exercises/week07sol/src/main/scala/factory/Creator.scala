package factory

object Creator {
  def getProduct: Product = getProduct("")

  def getProduct(s: String): Product = new ConcreteProduct(s)
}
