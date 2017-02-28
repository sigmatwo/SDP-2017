package iterator

import java.util.Hashtable
import java.util.Iterator

class SongsOfThe90s() extends SongIterator {
  addSong("Losing My Religion", "REM", 1991)
  addSong("Creep", "Radiohead", 1993)
  addSong("Walk on the Ocean", "Toad The Wet Sprocket", 1991)
  // Create a Hashtable with an int as a key and SongInfo
  // Objects
  private[iterator] val bestSongs: util.Hashtable[Integer, SongInfo] = new util.Hashtable[Integer, SongInfo]
  // Will increment the Hashtable key
  private[iterator] var hashKey: Int = 0

  // Add a new SongInfo Object to the Hashtable and then increment
  // the Hashtable key
  def addSong(songName: String, bandName: String, yearReleased: Int) {
    val songInfo: SongInfo = new SongInfo(songName, bandName, yearReleased)
    bestSongs.put(hashKey, songInfo)
    hashKey += 1
  }

  // This is replaced by the Iterator
  // Return a Hashtable full of SongInfo Objects
  def getBestSongs: util.Hashtable[Integer, SongInfo] = {
    return bestSongs
  }

  // NEW By adding this method I'll be able to treat all
  // collections the same
  def createIterator: util.Iterator[_] = {
    // TODO Auto-generated method stub
    return bestSongs.values.iterator
  }
}
