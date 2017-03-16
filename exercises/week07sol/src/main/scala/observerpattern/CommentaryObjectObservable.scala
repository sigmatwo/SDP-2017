package observerpattern

import java.util.Observable

class CommentaryObjectObservable(val subjectDetails: String) extends Observable with Commentary {
  private var desc: String = null

  def setDesc(desc: String) {
    this.desc = desc
    setChanged()
    notifyObservers(desc)
  }
}
