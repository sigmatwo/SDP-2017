package iterator

import java.util.Iterator

trait SongIterator {
  def createIterator: util.Iterator[_]
}
