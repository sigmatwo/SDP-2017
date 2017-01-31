// reduceLeft takes a combiner function and applies it from left to
// right on the given collection:

(1 to 9).reduceLeft(_ * _)

// This yields
//
// (...((1 * 2) * 3) * ...) * 9

// Higher-order functions make it easy to parameterize a sort
// function:
//

def sortStr(s: String, f: (String, String) => Boolean): String = 
  s.split(" ").sortWith(f).mkString(" ")

sortStr("Mary had a little lamb", (_.length < _.length))
