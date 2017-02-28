package iterator

import java.util.ArrayList
import java.util.Enumeration
import java.util.Hashtable
import java.util.Iterator

class DiscJockey(// NEW Passing in song iterators
                 var iter70sSongs: SongIterator, var iter80sSongs: SongIterator, var iter90sSongs: SongIterator) {
  private[iterator] val songs70s: SongsOfThe70s = null
  private[iterator] val songs80s: SongsOfThe80s = null
  private[iterator] val songs90s: SongsOfThe90s = null

  /* OLD WAY
      public DiscJockey(SongsOfThe70s newSongs70s, SongsOfThe80s newSongs80s, SongsOfThe90s newSongs90s) {

      songs70s = newSongs70s;
      songs80s = newSongs80s;
      songs90s = newSongs90s;

    }
    */
  // NEW WAY Initialize the iterators
  def showTheSongs() {
    // Because the SongInfo Objects are stored in different
    // collections everything must be handled on an individual
    // basis. This is BAD!
    val aL70sSongs: util.ArrayList[_] = songs70s.getBestSongs
    System.out.println("Songs of the 70s\n")
    var i: Int = 0
    while (i < aL70sSongs.size) {
      {
        val bestSongs: SongInfo = aL70sSongs.get(i).asInstanceOf[SongInfo]
        System.out.println(bestSongs.getSongName)
        System.out.println(bestSongs.getBandName)
        System.out.println(bestSongs.getYearReleased + "\n")
      }
      {
        i += 1; i - 1
      }
    }
    val array80sSongs: Array[SongInfo] = songs80s.getBestSongs
    System.out.println("Songs of the 80s\n")
    var j: Int = 0
    while (j < array80sSongs.length) {
      {
        val bestSongs: SongInfo = array80sSongs(j)
        System.out.println(bestSongs.getSongName)
        System.out.println(bestSongs.getBandName)
        System.out.println(bestSongs.getYearReleased + "\n")
      }
      {
        j += 1; j - 1
      }
    }
    val ht90sSongs: util.Hashtable[Integer, SongInfo] = songs90s.getBestSongs
    System.out.println("Songs of the 90s\n")
    val e: util.Enumeration[Integer] = ht90sSongs.keys
    while (e.hasMoreElements) {
      {
        val bestSongs: SongInfo = ht90sSongs.get(e.nextElement)
        System.out.println(bestSongs.getSongName)
        System.out.println(bestSongs.getBandName)
        System.out.println(bestSongs.getYearReleased + "\n")
      }
    }
  }

  // Now that I can treat everything as an Iterator it cleans up
  // the code while allowing me to treat all collections as 1
  def showTheSongs2() {
    System.out.println("NEW WAY WITH ITERATOR\n")
    val Songs70s: util.Iterator[_] = iter70sSongs.createIterator
    val Songs80s: util.Iterator[_] = iter80sSongs.createIterator
    val Songs90s: util.Iterator[_] = iter90sSongs.createIterator
    System.out.println("Songs of the 70s\n")
    printTheSongs(Songs70s)
    System.out.println("Songs of the 80s\n")
    printTheSongs(Songs80s)
    System.out.println("Songs of the 90s\n")
    printTheSongs(Songs90s)
  }

  def printTheSongs(iterator: util.Iterator[_]) {
    while (iterator.hasNext) {
      {
        val songInfo: SongInfo = iterator.next.asInstanceOf[SongInfo]
        System.out.println(songInfo.getSongName)
        System.out.println(songInfo.getBandName)
        System.out.println(songInfo.getYearReleased + "\n")
      }
    }
  }
}
