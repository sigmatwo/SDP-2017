package iterator

// Will hold all of the info needed for each song
// I told all users to:
// 1. create a function named addSong() for adding song, band and release
// 2. create a function named getBestSongs() that will return the collection
//    of songs
class SongInfo(var songName: String, var bandName: String, var yearReleased: Int) {
  def getSongName: String = {
    return songName
  }

  def getBandName: String = {
    return bandName
  }

  def getYearReleased: Int = {
    return yearReleased
  }
}
