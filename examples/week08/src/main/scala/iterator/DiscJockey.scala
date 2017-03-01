package iterator

case class DiscJockey(iter70sSongs: SongIterator, iter80sSongs: SongIterator, iter90sSongs: SongIterator) {

  // NEW WAY Initialize the iterators
  def showTheSongs() {
    // As we can treat everything as an Iterator it cleans up
    // the code while allowing us to treat all collections uniformly

    println("Songs of the 70s\n")
    printSongInfo(iter70sSongs)

    println("Songs of the 80s\n")
    printSongInfo(iter80sSongs)

    println("Songs of the 90s\n")
    printSongInfo(iter90sSongs)
  }

  def printSongInfo(iterator: SongIterator) = {
    val it = iterator.createIterator
    while (it.hasNext){
      val song = it.next()
      println(song songName)
      println(song bandName)
      println(song yearReleased)
      println()
    }
  }
}
