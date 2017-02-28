package command

class Radio extends ElectronicDevice {
  private var volume: Int = 0

  def on() {
    System.out.println("Radio is on")
  }

  def off() {
    System.out.println("Radio is off")
  }

  def volumeUp() {
    volume += 1
    System.out.println("Radio Volume is at: " + volume)
  }

  def volumenDown() {
    volume -= 1
    System.out.println("Radio Volume is at: " + volume)
  }
}
