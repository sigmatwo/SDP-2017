package iterator

object RadioStation {
  def main(args: Array[String]) {
    val songs70s: SongsOfThe70s = new SongsOfThe70s
    val songs80s: SongsOfThe80s = new SongsOfThe80s
    val songs90s: SongsOfThe90s = new SongsOfThe90s
    val madMike: DiscJockey = new DiscJockey(songs70s, songs80s, songs90s)
    // madMike.showTheSongs();
    madMike.showTheSongs2()
  }
}
