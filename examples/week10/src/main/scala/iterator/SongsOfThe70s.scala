package iterator

import scala.collection.mutable.ArrayBuffer

case class SongsOfThe70s() extends SongIterator {
  // ArrayList holds SongInfo objects
  private[iterator] var bestSongs = ArrayBuffer[SongInfo]()

  addSong("Imagine", "John Lennon", 1971)
  addSong("American Pie", "Don McLean", 1971)
  addSong("I Will Survive", "Gloria Gaynor", 1979)


  // Add a SongInfo object to the end of the ArrayList
  def addSong(songName: String, bandName: String, yearReleased: Int) {
    val songInfo: SongInfo = SongInfo(songName, bandName, yearReleased)
    bestSongs += songInfo
  }

  // Get rid of this
  // Return the ArrayList filled with SongInfo Objects
  def getBestSongs: ArrayBuffer[SongInfo] = bestSongs

  // NEW By adding this method I'll be able to treat all collections the same
  override def createIterator = bestSongs.iterator
}
