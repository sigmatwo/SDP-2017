// Imagine we want to model a sequence of statements as a function
// with no parameters or return value.
//
// For example, here is a function that runs some code in a thread:
//

def runInThread(block: () => Unit) {
  new Thread {
    override def run() { block() }
  }.start()
}

// We would then use this like so:
//

runInThread(() => {
  println("Hi")
  Thread.sleep(10000)
  println("Bye")
})

// This is certainly ugly, so how might we change this to make it a
// little more like a built-in control structure?
//
// In Scala, invoking methods with a single parameter can use { }
// instead of the typical ( ):
//

runInThread { 
  () => {
    println("Hi")
    Thread.sleep(10000)
    println("Bye")
  }
}

// This is ok, but still - it looks a little ugly. What we really want
// is something that looks like this:
//
// runInThread {
//   println("Hi")
//   Thread.sleep(10000)
//   println("Bye")
// }
//
// So, how can we do this?


// Typical functions are use *call by value* semantics for their
// parameters.
//
// That is, you evaluate a function by first evaluating its parameters
// then call the function.
//
// Scala also supports *call by name* parameters. In this case we
// first evaluate the function and when the parameter is referenced
// inside the body of the function - we evaluate it then:
//
def runInThread(block: => Unit) {
  new Thread {
    override def run() { block }
  }.start()
}

// We can then use it like this:
//

runInThread {
  println("Hi")
  Thread.sleep(10000)
  println("Bye")
}

// So, how might we implement a control structure that has the
// following semantics:
//
// unless (c) { body }
//
// The semantics for this are:
//
// if (!c) { body }
//

def unless(condition: => Boolean)(block: => Unit) =
  if (!(condition)) block

// And we could use it like this:
//

var x = 10
unless (x == 10) {
  println("x is not equal to 10")
}

unless (x == 5) {
  println("x is not equal to 5")
}


// Thinking Exercise:
//
// How might you implement the following control abstraction:
//
// until (condition) {
//   block
// }
//
// You should use recursion for this.

def until(condition: => Boolean)(block: => Unit) {
  if (!condition) {
    block
    until(condition)(block)
  }
}

// And here is an example:
//

var x = 10
until (x == 0) {
  x -= 1
  println(x)
}

// How cool is that?

