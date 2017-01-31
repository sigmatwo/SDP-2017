// There are many useful HOF functions.
//
// Consider map:
//
val x = (1 to 9).map(0.1 * _)

// Here is a function that prints a triangle:
//
def triangle(n: Int) = (1 to n).map("*" * _).foreach(println)

// Consider filter.
// filter yields all elements that match a particular condition.
//
def filterEven(n: Int) = (1 to n) filter (_ % 2 == 0)
def filterOdd(n: Int) = (1 to n) filter (_ % 2 != 0)

// How might we write a generic function called filterIntList that can
// be used to define filterEven and filterOdd?
