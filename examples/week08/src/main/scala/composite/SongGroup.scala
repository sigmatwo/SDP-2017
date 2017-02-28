package composite

import scala.collection.mutable.ListBuffer

case class SongGroup(// Contains any Songs or SongGroups that are added
                     // to this ArrayList
                     var groupName: String, var groupDescription: String) extends SongComponent {
  private[composite] var songComponents: ListBuffer[SongComponent] = new ListBuffer()

  override def add(newSongComponent: SongComponent) {
    songComponents += newSongComponent
  }

  override def remove(newSongComponent: SongComponent) {
    songComponents -= newSongComponent
  }

  override def getComponent(componentIndex: Int): SongComponent = {
    return songComponents.get(componentIndex).asInstanceOf[SongComponent]
  }

  override def displaySongInfo() {
    println(getGroupName + " " + getGroupDescription + "\n")
    // Cycles through and prints any Songs or SongGroups added
    // to this SongGroups ArrayList songComponents
    val songIterator: util.Iterator[_] = songComponents.iterator
    while (songIterator.hasNext) {
      {
        val songInfo: SongComponent = songIterator.next.asInstanceOf[SongComponent]
        songInfo.displaySongInfo()
      }
    }
  }

  def getGroupName: String = groupName

  def getGroupDescription: String = groupDescription
}
