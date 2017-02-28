package command

// Each command you want to issue will implement
// the Command interface
trait Command {
  def execute()

  // You may want to offer the option to undo a command
  def undo()
}
