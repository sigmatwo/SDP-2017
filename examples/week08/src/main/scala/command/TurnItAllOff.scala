package command

case class TurnItAllOff(theDevices: List[ElectronicDevice]) extends Command {
  override def execute() {
    for (device: ElectronicDevice <- theDevices) {
      device.off()
    }
  }

  override def undo() {
    for (device: ElectronicDevice <- theDevices) {
      device.on()
    }
  }
}
