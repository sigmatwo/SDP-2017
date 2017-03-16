package visitor

object VisitorTest {
  def main(args: Array[String]) {
    val taxCalc: TaxVisitor = new TaxVisitor
    val taxHolidayCalc: TaxHolidayVisitor = new TaxHolidayVisitor
    val milk: Necessity = new Necessity(3.47)
    val vodka: Liquor = new Liquor(11.99)
    val cigars: Tobacco = new Tobacco(19.99)
    System.out.println(milk.accept(taxCalc) + "\n")
    System.out.println(vodka.accept(taxCalc) + "\n")
    System.out.println(cigars.accept(taxCalc) + "\n")
    System.out.println("TAX HOLIDAY PRICES\n")
    System.out.println(milk.accept(taxHolidayCalc) + "\n")
    System.out.println(vodka.accept(taxHolidayCalc) + "\n")
    System.out.println(cigars.accept(taxHolidayCalc) + "\n")
  }
}
