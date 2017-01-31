//
// A review of functions in Scala:
//
// (1) Functions are "first-class citizens"
//
// (2) You can create "anonymous functions", usually to give them to
// other functions.
//
// (3) A function argument specifies behavior that should be executed
// later.
//
// (4) Many collection methods take function parameters, applying a
// function to the values of the collection.
//
// (5) There are syntax shortcuts that allow you to express function
// parameters in a way that is short and easy to read.
//
// (6) You can create functions that operate on blocks of code and
// look much like the built-in control statements.
//

import scala.math._
val num = 3.14
val fun = ceil _ // The '_' indicates that you didn't want to call it.

// The type of num is Double
// The type of fun is (Double) =>  Double
//
// What can you do with a function?
//
// (1) Call it.
// (2) Pass it around, store it in a variable, return it, ...
