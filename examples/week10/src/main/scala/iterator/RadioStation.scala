package iterator

object RadioStation {
  def main(args: Array[String]) {
    val songs70s = SongsOfThe70s()
    val songs80s = SongsOfThe80s()
    val songs90s = SongsOfThe90s()
    val madMike: DiscJockey = DiscJockey(songs70s, songs80s, songs90s)
    madMike.showTheSongs();
  }
}
