// A function to pass another function to it:

// A function that takes another function that gets called with 0.25
// as its parameter.
//
// Note: f can be *any* function receiving and returning a Double.
//
def valueAtOneQuarter(f: (Double) => Double) = f(0.25)

// Here is an example of calling it:
//
valueAtOneQuarter(ceil _)
valueAtOneQuarter(sqrt _)

// Right, so valueAtOneQuarter is a higher-order function.

// A higher-order function can also produce a function:
//
def mulBy(factor: Double) = (x: Double) => factor * x

// So, you can call it and save the resulting function:
//
val m5 = mulBy(5)

// Then call it:
//
m5(6)
