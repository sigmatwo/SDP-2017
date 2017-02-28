package template

case class ItalianSub() extends Sub {
  private[template] val meatUsed = Array("Salami", "Pepperoni", "Capicola Ham")
  private[template] val cheeseUsed = Array("Provolone")
  private[template] val veggiesUsed = Array("Lettuce", "Tomatoes", "Onions", "Sweet Peppers")
  private[template] val condimentsUsed = Array("Oil", "Vinegar")

  override def addMeat() {
    print("Adding the Meat: ")
    for (meat <- meatUsed) {
      print(meat + " ")
    }
  }

  override def addCheese() {
    print("Adding the Cheese: ")
    for (cheese <- cheeseUsed) {
      print(cheese + " ")
    }
  }

  override def addVegetables() {
    print("Adding the Vegetables: ")
    for (vegetable <- veggiesUsed) {
      print(vegetable + " ")
    }
  }

  override def addCondiments() {
    print("Adding the Condiments: ")
    for (condiment <- condimentsUsed) {
      print(condiment + " ")
    }
  }
}

/*
  public void makeSandwich(){

  cutBun();
  addMeat();
  addCheese();
  addVegetables();
  addCondiments();
  wrapTheHoagie();

}

public void cutBun(){

  System.out.println("The Hoagie is Cut");

}

public void addMeat(){

  System.out.println("Add Salami, Pepperoni and Capicola ham");

}

public void addCheese(){

  System.out.println("Add Provolone");

}

public void addVegetables(){

  System.out.println("Add Lettuce, Tomatoes, Onions and Sweet Peppers");

}

public void addCondiments(){

  System.out.println("Add Oil and Vinegar");

}

public void wrapTheHoagie(){

  System.out.println("Wrap the Hoagie");

}

}
*/
