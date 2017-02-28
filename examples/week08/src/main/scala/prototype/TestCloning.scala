package prototype

object TestCloning {
  def main(args: Array[String]) {
    // Handles routing makeCopy method calls to the
    // right subclasses of Animal
    val animalMaker: CloneFactory = new CloneFactory
    // Creates a new Sheep instance
    val sally: Sheep = new Sheep
    // Creates a clone of Sally and stores it in its own
    // memory location
    val clonedSheep: Sheep = animalMaker.getClone(sally).asInstanceOf[Sheep]
    // These are exact copies of each other
    System.out.println(sally)
    System.out.println(clonedSheep)
    System.out.println("Sally HashCode: " + System.identityHashCode(System.identityHashCode(sally)))
    System.out.println("Clone HashCode: " + System.identityHashCode(System.identityHashCode(clonedSheep)))
  }
}
