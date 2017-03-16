package observerpattern

import scala.collection.mutable.ArrayBuffer
import observer.Observer

class CommentaryObject(val observers: ArrayBuffer[Observer], val subjectDetails: String) extends Subject with Commentary {
  private var desc: String = null

  def subscribeObserver(observer: Observer) = observers += observer

  def unSubscribeObserver(observer: Observer) = {
    observers -= observer
  }

  def notifyObservers() = {
    for (observer <- observers) {
      observer.update(desc)
    }
  }

  def setDesc(desc: String) = {
    this.desc = desc
    notifyObservers()
  }
}
