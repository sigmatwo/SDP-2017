// When you pass an anonymous function to another function or method,
// scala helps you out be deducing types when possible.
//

def valueAtOneQuarter(f: (Double) => Double) = f(0.25)

// Types specified:
valueAtOneQuarter((x: Double) => 3 * x)

// Without the parameter type:
valueAtOneQuarter((x) => 3 * x)

// Removing the parenthesis:
valueAtOneQuarter(x => 3 * x)

// Shorthand:
valueAtOneQuarter(3 * _)
