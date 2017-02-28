package flyweight

// The Flyweight design pattern is used when you need to
// create a large number of similar objects
// To reduce memory this pattern shares Objects that are
// the same rather than creating new ones
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JPanel
import java.awt.BorderLayout
import java.awt.Color
import java.awt.Graphics
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.util.Random

@SerialVersionUID(1L)
object FlyWeightTest {
  // A new rectangle is created only if a new color is needed
  def main(args: Array[String]) {
    new FlyWeightTest
  }
}

@SerialVersionUID(1L)
class FlyWeightTest() extends JFrame {
  // Create the frame, position it and handle closing it
  this.setSize(windowWidth, windowHeight)
  this.setLocationRelativeTo(null)
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
  this.setTitle("Flyweight Test")
  val contentPane: JPanel = new JPanel
  contentPane.setLayout(new BorderLayout)
  val drawingPanel: JPanel = new JPanel
  startDrawing = new JButton("Button 1")
  contentPane.add(drawingPanel, BorderLayout.CENTER)
  contentPane.add(startDrawing, BorderLayout.SOUTH)
  startDrawing.addActionListener(new ActionListener() {
    def actionPerformed(event: ActionEvent) {
      val g: Graphics = drawingPanel.getGraphics
      val startTime: Long = System.currentTimeMillis
      var i: Int = 0
      while (i < 100000) {
        {
          //
          // Uses rectangles stored in the HashMap to
          // speed up the program
          val rect: MyRect = RectFactory.getRect(getRandColor)
          rect.draw(g, getRandX, getRandY, getRandX, getRandY)
          //
          /*
                              MyRect rect = new MyRect(getRandColor(), getRandX(), getRandY(), getRandX(), getRandY());
                          rect.draw(g);
                          */
          //
          /*
                          g.setColor(getRandColor());
                          g.fillRect(getRandX(), getRandY(), getRandX(), getRandY());
                          */
        }
        {
          i += 1; i
        }
      }
      val endTime: Long = System.currentTimeMillis
      System.out.println("That took " + (endTime - startTime) + " milliseconds")
    }
  })
  this.add(contentPane)
  this.setVisible(true)
  private[flyweight] var startDrawing: JButton = null
  private[flyweight] val windowWidth: Int = 1750
  private[flyweight] val windowHeight: Int = 1000
  private[flyweight] val shapeColor: Array[Color] = Array(Color.orange, Color.red, Color.yellow, Color.blue, Color.pink, Color.cyan, Color.magenta, Color.black, Color.gray)

  // Picks random x & y coordinates
  private def getRandX: Int = {
    return (Math.random * windowWidth).toInt
  }

  private def getRandY: Int = {
    return (Math.random * windowHeight).toInt
  }

  // Picks a random Color from the 9 available
  private def getRandColor: Color = {
    val randomGenerator: Random = new Random
    val randInt: Int = randomGenerator.nextInt(9)
    return shapeColor(randInt)
  }
}
