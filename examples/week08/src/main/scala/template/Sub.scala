package template

// A Template Method Pattern contains a method that provides
// the steps of the algorithm. It allows subclasses to override
// some of the methods
abstract class Sub {

  // This is the Template Method
  // Declare this method final to keep subclasses from
  // changing the algorithm
  final private[template]
  def makeSandwich() {
    cutBun()
    if (customerWantsMeat) {
      addMeat()
    }
    if (customerWantsCheese) {
      addCheese()
    }
    if (customerWantsVegetables) {
      addVegetables()
    }
    if (customerWantsCondiments) {
      addCondiments()
    }
    wrapTheHoagie()
  }

  def cutBun() {
    System.out.println("The Hoagie is Cut")
  }

  // These are called hooks
  // If the user wants to override these they can
  // Use abstract methods when you want to force the user
  // to override and use a hook when you want it to be optional
  private[template] def customerWantsMeat: Boolean = true

  private[template] def customerWantsCheese: Boolean = true

  private[template] def customerWantsVegetables: Boolean = true

  private[template] def customerWantsCondiments: Boolean = true

  def wrapTheHoagie() = println("\nWrap the Hoagie")

  // These methods must be overridden by the extending subclasses
  private[template] def addMeat()

  private[template] def addCheese()

  private[template] def addVegetables()

  private[template] def addCondiments()
}
