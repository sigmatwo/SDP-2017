package visitor

class Necessity private[visitor](var price: Double) extends Visitable {
  def accept(visitor: Visitor): Double = {
    return visitor.visit(this)
  }

  def getPrice: Double = {
    return price
  }
}
