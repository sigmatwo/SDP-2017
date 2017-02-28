package iterator

import java.util.ArrayList
import java.util.Iterator

class SongsOfThe70s() extends SongIterator {
  bestSongs = new util.ArrayList[SongInfo]
  addSong("Imagine", "John Lennon", 1971)
  addSong("American Pie", "Don McLean", 1971)
  addSong("I Will Survive", "Gloria Gaynor", 1979)
  // ArrayList holds SongInfo objects
  private[iterator] var bestSongs: util.ArrayList[SongInfo] = null

  // Add a SongInfo object to the end of the ArrayList
  def addSong(songName: String, bandName: String, yearReleased: Int) {
    val songInfo: SongInfo = new SongInfo(songName, bandName, yearReleased)
    bestSongs.add(songInfo)
  }

  // Get rid of this
  // Return the ArrayList filled with SongInfo Objects
  def getBestSongs: util.ArrayList[SongInfo] = {
    return bestSongs
  }

  // NEW By adding this method I'll be able to treat all
  // collections the same
  def createIterator: util.Iterator[_] = {
    return bestSongs.iterator
  }
}
