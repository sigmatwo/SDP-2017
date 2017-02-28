package memento

// Memento Design Pattern
case class Originator() {
  private var article: String = null

  // Sets the value for the article
  def set(newArticle: String) {
    println("From Originator: Current Version of Article\n" + newArticle + "\n")
    article = newArticle
  }

  // Creates a new Memento with a new article
  def storeInMemento: Memento = {
    println("From Originator: Saving to Memento")
    Memento(article)
  }

  // Gets the article currently stored in memento
  def restoreFromMemento(memento: Memento): String = {
    article = memento.getSavedArticle
    println("From Originator: Previous Article Saved in Memento\n" + article + "\n")
    article
  }
}
