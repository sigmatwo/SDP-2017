object Singleton {
//    private val instance = new Singleton()
    var args = 0
    lazy val x = args

    def setOnce(arg: Int) = {
        args = arg
        println("The value of x is " + x)
    }
}

class Singleton private()

case class SingletonCC private()

//class Singleton private(x: Int){

object Main extends App {
    val xx = Singleton
    //println(xx.args)
    xx.setOnce(3)
    println(xx.x)

    val yy = Singleton
    yy.setOnce(3121)
    println(yy.x)
    
    //x.apply(3)
    //val y = Singleton(4)
    //val x = new Singleton(3) --- won't work
    //println(x)
    //println(y)
}