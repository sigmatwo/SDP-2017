package command

import scala.collection.mutable.ListBuffer

object PlayWithRemote extends App {
  // Gets the ElectronicDevice to use
  val newDevice: ElectronicDevice = TVRemote.getDevice
  // TurnTVOn contains the command to turn on the tv
  // When execute() is called on this command object
  // it will execute the method on() in Television
  val onCommand: TurnTVOn = new TurnTVOn(newDevice)
  //----------------------------------------------------------
  // Now when execute() is called off() of Television executes
  val offCommand: TurnTVOff = new TurnTVOff(newDevice)
  // When press() is called theCommand.execute(); executes
  onPressed.press()
  //----------------------------------------------------------
  // Now when execute() is called volumeUp() of Television executes
  val volUpCommand: TurnTVUp = new TurnTVUp(newDevice)
  // Calling the execute() causes off() to execute in Television
  onPressed = new DeviceButton(offCommand)
  // When press() is called theCommand.execute(); executes
  onPressed.press()
  //----------------------------------------------------------
  // Creating a TV and Radio to turn off with 1 press
  val theTV: Television = new Television
  // Calling the execute() causes volumeUp() to execute in Television
  onPressed = new DeviceButton(volUpCommand)
  // When press() is called theCommand.execute(); executes
  onPressed.press()
  onPressed.press()
  onPressed.press()
  val theRadio: Radio = new Radio
  // Add the Electronic Devices to a List
  var allDevices: ListBuffer[ElectronicDevice] = ListBuffer()
  // Send the List of Electronic Devices to TurnItAllOff
  // where a call to run execute() on this function will
  // call off() for each device in the list
  val turnOffDevices: TurnItAllOff = TurnItAllOff(allDevices.toList)
  allDevices += theTV
  allDevices += theRadio
  // This calls for execute() to run which calls for off() to
  // run for every ElectronicDevice
  val turnThemOff: DeviceButton = new DeviceButton(turnOffDevices)
  // Calling the execute() causes on() to execute in Television
  var onPressed: DeviceButton = new DeviceButton(onCommand)
  turnThemOff.press()
  //----------------------------------------------------------
  /*
   * It is common to be able to undo a command in a command pattern
   * To do so, DeviceButton will have a method called undo
   * Undo() will perform the opposite action that the normal
   * Command performs. undo() needs to be added to every class
   * with an execute()
   */
  turnThemOff.pressUndo()
  // To undo more than one command add them to a LinkedList
  // using addFirst(). Then execute undo on each item until
  // there are none left. (This is your Homework)
}
