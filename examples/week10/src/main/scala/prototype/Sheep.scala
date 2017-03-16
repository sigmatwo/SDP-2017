package prototype

class Sheep() extends Animal {
  System.out.println("Sheep is Made")

  def makeCopy: Animal = {
    System.out.println("Sheep is Being Made")
    var sheepObject: Sheep = null
    try {
      // Calls the Animal super classes clone()
      // Then casts the results to Sheep
      sheepObject = super.clone.asInstanceOf[Sheep]
    }
    catch {
      case e: CloneNotSupportedException => {
        System.out.println("The Sheep was Turned to Mush")
        e.printStackTrace()
      }
    } // If Animal didn't extend Cloneable this error
    // is thrown
    return sheepObject
  }

  override def toString: String = {
    return "Dolly is my Hero, Baaaaa"
  }
}
