package command

case class Television() extends ElectronicDevice {
  private var volume: Int = 0

  override def on() = println("TV is on")

  override def off() = println("TV is off")

  override def volumeUp() = {
    volume += 1
    println("TV Volume is at: " + volume)
  }

  override def volumenDown() {
    volume -= 1
    println("TV Volume is at: " + volume)
  }
}
