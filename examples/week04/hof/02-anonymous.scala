// In scala you do not need to give a function a name, just like you
// do not need to give a number a name.
//
// A function without a name is called an *anonymous function*.
//
// Here is an example:

(x: Double) => 3 * x

// Of course, you can store this function in a variable:

val triple = (x: Double) => 3 * x

// This is similiar as if you had used def:
//
// def triple(x: Double) = 3 * x

// But, you need not name a function to pass it to another function.

Array(3.14, 1.42, 2.0).map((x: Double) => 3 * x)

// Note: map abstracts loops away.
