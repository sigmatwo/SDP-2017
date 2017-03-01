package flyweight

import java.awt.Color
import java.awt.Graphics

case class MyRect(color: Color = Color.black) {
  private val x: Int = 0
  private val y: Int = 0
  private val x2: Int = 0
  private val y2: Int = 0

  def draw(g: Graphics, upperX: Int, upperY: Int, lowerX: Int, lowerY: Int) {
    g.setColor(color)
    g.fillRect(upperX, upperY, lowerX, lowerY)
  }
}
