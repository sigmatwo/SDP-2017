object Implicit extends App {
    implicit var multiplier = 2

    def multiply(implicit x: Int,  by: Int) = x * by

    println(multiply)

    multiplier = 4

    println(multiply)

}