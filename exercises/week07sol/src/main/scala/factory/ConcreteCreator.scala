package factory

object ConcreteCreator {
  private[factory] def getProduct: Product = Creator.getProduct("")
}
