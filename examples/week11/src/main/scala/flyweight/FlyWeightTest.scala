package flyweight

// The Flyweight design pattern is used when you need to create a large number of similar objects
// To reduce memory this pattern shares Objects that are the same rather than creating new ones

import java.awt.event.{ActionEvent, ActionListener}
import java.awt.{BorderLayout, Color, Graphics}
import java.util.Random
import javax.swing.{JButton, JFrame, JPanel}

@SerialVersionUID(1L)
object FlyWeightTest extends App {
  // A new rectangle is created only if a new color is needed
  FlyWeightTest
}

@SerialVersionUID(1L)
case class FlyWeightTest() extends JFrame {
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

    override def actionPerformed(event: ActionEvent) {
      val g: Graphics = drawingPanel.getGraphics
      val startTime: Long = System.currentTimeMillis
      var i: Int = 0
      while (i < 100000) {
        //
        // Uses rectangles stored in the HashMap to
        // speed up the program
        val rect: MyRect = RectFactory.getRect(getRandColor)
        rect.draw(g, getRandX, getRandY, getRandX, getRandY)
        i += 1;
      }
      val endTime: Long = System.currentTimeMillis
      println("That took " + (endTime - startTime) + " milliseconds")
    }
  })
  this.add(contentPane)
  this.setVisible(true)

  private[flyweight] val windowWidth: Int = 1750
  private[flyweight] val windowHeight: Int = 1000
  private[flyweight] val shapeColor: Array[Color] =
    Array(Color.orange, Color.red, Color.yellow, Color.blue, Color.pink, Color.cyan,
      Color.magenta, Color.black, Color.gray)
  private[flyweight] var startDrawing: JButton = null

  // Picks random x & y coordinates
  private def getRandX: Int = (Math.random * windowWidth).toInt

  private def getRandY: Int = (Math.random * windowHeight).toInt

  // Picks a random Color from the 9 available
  private def getRandColor: Color = shapeColor(new Random().nextInt(9))
}
