package decoratorpattern

import java.text.DecimalFormat

object TestDecoratorPattern extends App {
    val dformat = new DecimalFormat("#.##")
    var pizza: Pizza = new SimplyVegPizza
    pizza = new RomaTomatoes(pizza)
    pizza = new GreenOlives(pizza)
    pizza = new Spinach(pizza)
    println("Desc: " + pizza.getDesc)
    println("Price: " + dformat.format(pizza.getPrice))
    pizza = new SimplyNonVegPizza
    pizza = new Meat(pizza)
    pizza = new Cheese(pizza)
    pizza = new Cheese(pizza)
    pizza = new Ham(pizza)
    println("Desc: " + pizza.getDesc)
    println("Price: " + dformat.format(pizza.getPrice))
}