package flyweight

import java.awt.Color
import java.awt.Graphics

class MyRect(val color: Color) {
  this.color = color
  private var color: Color = Color.black
  private val x: Int = 0
  private val y: Int = 0
  private val x2: Int = 0
  private val y2: Int = 0

  def draw(g: Graphics, upperX: Int, upperY: Int, lowerX: Int, lowerY: Int) {
    g.setColor(color)
    g.fillRect(upperX, upperY, lowerX, lowerY)
  }

  /* Original forces creation of a rectangle every time

     public MyRect(Color color, int upperX, int upperY, int lowerX, int lowerY) {
        this.color = color;
        this.x = upperX;
        this.y = upperY;
        this.x2 = lowerX;
        this.y2 = lowerY;
     }

     public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, x2, y2);
     }
     */
}
