package command

case class Radio() extends ElectronicDevice {
  private var volume: Int = 0

  override def on() = println("Radio is on")

  override def off() =println("Radio is off")

  override def volumeUp() = {
    volume += 1
    println("Radio Volume is at: " + volume)
  }

  override def volumenDown() = {
    volume -= 1
    println("Radio Volume is at: " + volume)
  }
}
