package memento

// Memento Design Pattern Tutorial
import java.awt.event.{ActionEvent, ActionListener}
import javax.swing._

object TestMemento {
  def main(args: Array[String]) {
    TestMemento()
  }
}

case class TestMemento() extends JFrame {
  // Set basic information for the panel that will
  // hold all the GUI elements
  this.setSize(750, 780)
  this.setTitle("Memento Design Pattern")
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
  val panel1: JPanel = new JPanel

  // Add label to the panel
  panel1.add(new JLabel("Article"))

  // Add JTextArea to the panel
  panel1.add(theArticle)

  // Add the buttons & ButtonListeners to the panel
  val saveListener = new ButtonListener
  val undoListener = new ButtonListener
  val redoListener = new ButtonListener

  saveBut = new JButton("Save")
  saveBut.addActionListener(saveListener)
  undoBut = new JButton("Undo")
  undoBut.addActionListener(undoListener)
  redoBut = new JButton("Redo")
  redoBut.addActionListener(redoListener)

  panel1.add(saveBut)
  panel1.add(undoBut)
  panel1.add(redoBut)

  // Add panel to the frame that shows on screen
  this.add(panel1)
  this.setVisible(true)
  private[memento] val caretaker: Caretaker = new Caretaker
  private[memento] val originator: Originator = new Originator
  // The originator sets the value for the article,
  // creates a new memento with a new article, and
  // gets the article stored in the current memento
  private val theArticle: JTextArea = new JTextArea(40, 60)
  // JTextArea(rows, columns)
  private[memento] var saveFiles: Int = 0
  private[memento] var currentArticle: Int = 0
  // Create a caretaker that contains the ArrayList
  // with all the articles in it. It can add and
  // retrieve articles from the ArrayList
  private var saveBut: JButton = null
  private var undoBut: JButton = null
  private var redoBut: JButton = null

  private[memento] class ButtonListener extends ActionListener {
    def actionPerformed(e: ActionEvent) {
      if (e.getSource eq saveBut) {
        // Get text in JTextArea
        val textInTextArea: String = theArticle.getText
        // Set the value for the current memento
        originator.set(textInTextArea)

        // Add new article to the ArrayList
        caretaker.addMemento(originator.storeInMemento)

        // saveFiles monitors how many articles are saved
        // currentArticle monitors the current article displayed
        saveFiles += 1
        currentArticle += 1

        println("Save Files " + saveFiles)
        // Make undo clickable
        undoBut.setEnabled(true)
      }
      else if (e.getSource eq undoBut) {
        if (currentArticle >= 1) {
          // Decrement to the current article displayed
          currentArticle -= 1

          // Get the older article saved and display it in JTextArea
          val textBoxString: String = originator.restoreFromMemento(caretaker.getMemento(currentArticle))
          theArticle.setText(textBoxString)

          // Make Redo clickable
          redoBut.setEnabled(true)
        }
        else {
          // Don't allow user to click Undo
          undoBut.setEnabled(false)
        }
      }
      else if (e.getSource eq redoBut) {
        if ((saveFiles - 1) > currentArticle) {
          // Increment to the current article displayed
          currentArticle += 1

          // Get the newer article saved and display it in JTextArea
          val textBoxString: String = originator.restoreFromMemento(caretaker.getMemento(currentArticle))
          theArticle.setText(textBoxString)

          // Make undo clickable
          undoBut.setEnabled(true)
        }
        else {
          // Don't allow user to click Redo
          redoBut.setEnabled(false)
        }
      }
    }
  }

}
