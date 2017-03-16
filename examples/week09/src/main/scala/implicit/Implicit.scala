object Implicit extends App {
    // implicit var multiplier = 2

    val r = scala.util.Random
    // The compiler would try to resolve this as multiply(f()) as it produces an Int which multiply requires.
    implicit def f: Int = if (r.nextInt(2) == 0) 4 else 2

    // You can only use implicit once in a parameter list and all parameters following it will be implicit. For example,
    def multiply(implicit x: Int,  by: Int) = x * by

    def multiply2(x: Int)(implicit by: Int) = x * by

    println(multiply)
    println(multiply2(6))

    //multiplier = 4

    println(multiply)
    println(multiply2(8))

    //def example1(implicit x: Int)                       // x is implicit
    //def example2(implicit x: Int, y: Int)               // x and y are implicit
    //def example3(x: Int, implicit y: Int)               // wont compile 
    //def example4(x: Int)(implicit y: Int)               // only y is implicit
    //def example5(implicit x: Int)(y: Int)               // wont compile
    //def example6(implicit x: Int)(implicit y: Int)      // wont compile
}