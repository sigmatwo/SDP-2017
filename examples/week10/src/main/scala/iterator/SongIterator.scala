package iterator

trait SongIterator {
  def createIterator: Iterator[SongInfo]
}
