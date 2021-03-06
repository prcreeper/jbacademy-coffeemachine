package machine

import java.util.Scanner

fun main() = Scanner(System.`in`).let { scn: Scanner ->
    do {
        print("Write action (buy, fill, take, remaining, exit): ")
        scn.next().let {
            when (it) {
                "buy" -> {
                    Machine.interact(it)
                    print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ")
                    Machine.interact(scn.next())
                    println()
                }
                "fill" -> {
                    Machine.interact(it)
                    IntArray(4).let {array ->
                        repeat(4) { ctr ->
                            val resource = when (ctr) {
                                0 -> "water"
                                1 -> "milk"
                                2 -> "coffee beans"
                                3 -> "disposable cups"
                                else -> ""
                            }
                            val measure = when (ctr) {
                                0, 1 -> " ml of"
                                2 ->  " grams of"
                                else -> ""
                            }
                            print("Write how many$measure $resource do you want to add: ")
                            array[ctr] = scn.nextInt()
                        }
                        Machine.interact(array)
                    }
                }
                "remaining" -> {
                    println("The coffee machine has:")
                    println("${Machine.water} of water\n" +
                            "${Machine.milk} of milk\n" +
                            "${Machine.coffee} of coffee beans\n" +
                            "${Machine.cups} of disposable cups\n" +
                            "\$${Machine.money} of money")
                }
                "exit" -> return@main
                else -> Machine.interact(it)
            }
        }
        } while (true)

}

