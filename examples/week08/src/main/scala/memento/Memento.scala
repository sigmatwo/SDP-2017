package memento

// Memento Design Pattern
// Used stores an objects state at a point in time
// so it can be returned to that state later. It
// simply allows you to undo/redo changes on an Object

case class Memento(// The article stored in memento Object
              var article: String) {
  // Save a new article String to the memento Object
  // Return the value stored in article
  def getSavedArticle: String = article
}
