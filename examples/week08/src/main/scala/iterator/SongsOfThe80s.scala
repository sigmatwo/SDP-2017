package iterator

case class SongsOfThe80s() extends SongIterator {
  private[iterator] var bestSongs = new Array[SongInfo](3)
  addSong("Roam", "B 52s", 1989)
  addSong("Cruel Summer", "Bananarama", 1984)
  addSong("Head Over Heels", "Tears For Fears", 1985)

  // Create an array of SongInfo Objects
  // Used to increment to the next position in the array
  private[iterator] var arrayValue: Int = 0

  // Add a SongInfo Object to the array and increment to the next position
  def addSong(songName: String, bandName: String, yearReleased: Int) {
    val song: SongInfo = SongInfo(songName, bandName, yearReleased)
    bestSongs(arrayValue) = song
    arrayValue += 1
  }

  // This is replaced by the Iterator
  def getBestSongs: Array[SongInfo] = bestSongs


  // NEW By adding this method I'll be able to treat all
  // collections the same
  override def createIterator = bestSongs.iterator
}
