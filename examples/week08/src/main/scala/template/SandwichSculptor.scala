package template

object SandwichSculptor {
  def main(args: Array[String]) {
    val cust12Hoagie = ItalianSub()
    cust12Hoagie.makeSandwich()
    println()

    val cust13Hoagie  = VeggieSub()
    cust13Hoagie.makeSandwich()
  }
}
