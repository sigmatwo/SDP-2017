package command

case class TurnTVOff(var theDevice: ElectronicDevice) extends Command {
  override def execute() = theDevice.off()

  // Used if you want to allow for undo
  // Do the opposite of execute()
  override def undo() = theDevice.on()
}
