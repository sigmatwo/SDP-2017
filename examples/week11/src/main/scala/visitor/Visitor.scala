package visitor

// The visitor pattern is used when you have to perform
// the same action on many objects of different types
trait Visitor {
  // Created to automatically use the right
  // code based on the Object sent
  // Method Overloading
  def visit(liquorItem: Liquor): Double

  def visit(tobaccoItem: Tobacco): Double

  def visit(necessityItem: Necessity): Double
}
