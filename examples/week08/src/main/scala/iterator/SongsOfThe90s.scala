package iterator

import scala.collection.mutable.HashMap

case class SongsOfThe90s() extends SongIterator {
  private[iterator] val bestSongs = new HashMap[Integer, SongInfo]

  addSong("Losing My Religion", "REM", 1991)
  addSong("Creep", "Radiohead", 1993)
  addSong("Walk on the Ocean", "Toad The Wet Sprocket", 1991)

  // Create a HashMap with an int as a key and SongInfo Objects
  // Will increment the HashMap key
  private[iterator] var hashKey: Int = 0

  // Add a new SongInfo Object to the HashMap and then increment the HashMap key
  def addSong(songName: String, bandName: String, yearReleased: Int) {
    val songInfo: SongInfo = SongInfo(songName, bandName, yearReleased)
    bestSongs.put(hashKey, songInfo)
    hashKey += 1
  }

  // This is replaced by the Iterator
  // Return a HashMap full of SongInfo Objects
  def getBestSongs: HashMap[Integer, SongInfo] = bestSongs

  // NEW By adding this method I'll be able to treat all
  // collections the same
  override def createIterator = bestSongs.valuesIterator
}
