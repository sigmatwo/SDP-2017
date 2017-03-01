package flyweight

// This factory only creates a new rectangle if it
// uses a color not previously used
// Intrinsic State: Color
// Extrinsic State: X & Y Values
import java.awt.Color
import scala.collection.mutable.HashMap

object RectFactory {
  // The HashMap uses the color as the key for every
  // rectangle it will make up to 8 total
  private val rectsByColor = HashMap[Color, MyRect]()

  def getRect(color: Color): MyRect = {
    var rect: MyRect = rectsByColor.get(color).asInstanceOf[MyRect]
    // Checks if a rectangle with a specific
    // color has been made. If not it makes a
    // new one, otherwise it returns one made already
    if (rect == null) {
      rect = new MyRect(color)
      // Add new rectangle to HashMap
      rectsByColor.put(color, rect)
    }
    rect
  }
}
