// A simple object defining some methods.
object Higher {
  // Returns the absolute value.
  def abs(n: Int): Int = if (n < 0) -n else n

  // ADDITION
  // The `go` function is a tail-recursive function. A function is
  // tail-recursive if a recursive call does nothing more than return
  // the value of the recursive call. This can be translated into a
  // loop by the Scala compiler :-)
  def factorial(n: Int): Int = {
    // An inner function can be defined to perform
    def go(n: Int, acc: Int): Int =
      if (n <= 0) acc
      else go(n-1, n*acc)

    go(n, 1)
  }

  // Returns a string formatted result of absolute value.
  private def formatAbs(x: Int) = {
    val msg = "The absolute value of %d is %d"
    msg.format(x, abs(x))
  }

  // ADDITION
  // We include another format function.
  private def formatFac(n: Int) = {
    val msg = "The factorial of %d is %d"
    msg.format(n, factorial(n))
  }

  // A way to run this from the command line.
  def main(args: Array[String]): Unit = {
    println(formatAbs(-42))
    println(formatFac(7))
  }
}
