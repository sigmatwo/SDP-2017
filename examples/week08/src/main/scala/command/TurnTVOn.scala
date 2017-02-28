package command

class TurnTVOn(var theDevice: ElectronicDevice) extends Command {
  def execute() {
    theDevice.on()
  }

  def undo() {
    theDevice.off()
  }
}
