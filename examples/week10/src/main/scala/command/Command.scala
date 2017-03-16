package command

// Each command you want to issue will implement
// the Command interface
sealed trait Command {
  def execute()

  // You may want to offer the option to undo a command
  def undo()
}

final case class TurnItAllOff(theDevices: List[ElectronicDevice]) extends Command {
  override def execute() = theDevices.foreach(_.off())

  override def undo() = theDevices.foreach(_.on())
}

final case class TurnTVOff(theDevice: ElectronicDevice) extends Command {
  override def execute() = theDevice.off()

  // Used if you want to allow for undo
  // Do the opposite of execute()
  override def undo() = theDevice.on()
}

final case class TurnTVOn(theDevice: ElectronicDevice) extends Command {
  override def execute() = theDevice.on()

  override def undo() = theDevice.off()
}

final case class TurnTVUp(theDevice: ElectronicDevice) extends Command {
  override def execute() = theDevice.volumeUp()

  override def undo() = theDevice.volumenDown()
}
