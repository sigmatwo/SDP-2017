package command

case class TurnTVUp(var theDevice: ElectronicDevice) extends Command {
  override def execute() = theDevice.volumeUp()

  override def undo() = theDevice.volumenDown()
}
