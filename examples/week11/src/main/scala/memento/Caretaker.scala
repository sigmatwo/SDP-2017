package memento

// Memento Design Pattern Tutorial

import scala.collection.mutable.ArrayBuffer
class Caretaker {
  // Where all mementos are saved
  private[memento] val savedArticles =  ArrayBuffer.empty[Memento]

  // Adds memento to the ArrayList
  def addMemento(m: Memento) {
    savedArticles += m
  }

  // Gets the memento requested from the List
  def getMemento(index: Int): Memento = savedArticles(index)
}
