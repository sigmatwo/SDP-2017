package template

case class VeggieSub() extends Sub {
  private[template] val veggiesUsed = Array("Lettuce", "Tomatoes", "Onions", "Sweet Peppers")
  private[template] val condimentsUsed = Array("Oil", "Vinegar")

  override private[template] def customerWantsMeat: Boolean = false

  override private[template] def customerWantsCheese: Boolean = false

  override def addVegetables() {
    System.out.print("Adding the Vegetables: ")
    for (vegetable <- veggiesUsed) {
      print(vegetable + " ")
    }
  }

  override def addCondiments() {
    System.out.print("Adding the Condiments: ")
    for (condiment <- condimentsUsed) {
      print(condiment + " ")
    }
  }

  override private[template] def addMeat() = println("You can't add meat")

  override private[template] def addCheese() = println("You can't add cheese")
}
