package visitor

import java.text.DecimalFormat
// Concrete Visitor Class
class TaxHolidayVisitor() extends Visitor {
  // This formats the item prices to 2 decimal places
  private[visitor] val df: DecimalFormat = new DecimalFormat("#.##")

  // This is created so that each item is sent to the
  // right version of visit() which is required by the
  // Visitor interface and defined below
  // Calculates total price based on this being taxed
  // as a liquor item
  def visit(liquorItem: Liquor): Double = {
    System.out.println("Liquor Item: Price with Tax")
    return df.format((liquorItem.getPrice * .10) + liquorItem.getPrice).toDouble
  }

  // Calculates total price based on this being taxed
  // as a tobacco item
  def visit(tobaccoItem: Tobacco): Double = {
    System.out.println("Tobacco Item: Price with Tax")
    return df.format((tobaccoItem.getPrice * .30) + tobaccoItem.getPrice).toDouble
  }

  // Calculates total price based on this being taxed
  // as a necessity item
  def visit(necessityItem: Necessity): Double = {
    System.out.println("Necessity Item: Price with Tax")
    return df.format(necessityItem.getPrice).toDouble
  }
}
