// In scala, you can define a function inside any scope.
//
// In the body of a function you can access any variables from an
// enclosing scope.
//
// Note: you function can also access a variable when the variable is
// no longer in scope.
//
// The following function demonstrates *closure*:

def incrementor(start: Int = 0, step: Int = 1) = {
  var b = start
  () => {
    val t = b
    b += step
    t
  }
}

// Each time we call incrementor we return a new function that
// "closes" the environment of the original function call. 
//
// Each time the incrementor function is called it allocates a new
// `start`, `step`, and `b` variable that is *captured* by the
// function that is returned.

val incOne = incrementor()
val incTwoByTwo = incrementor(2, 2)
