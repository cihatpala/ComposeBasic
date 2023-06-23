package com.example.composebasic.unit2.pathway1

/**unit2-pathway1 path1 Video **/
/**A-unit2-pathway1 path2 write conditionals in Kotlin**/
//A_1 Begin
//A_2 use if-elseif-else
//A_3 Use when statement for multiple branches
//A_4 Use if/else and when as expressions return different values for each branch of condition
fun main() {
    val trafficLightColor = "black"
    val number = 11

    /**A 2 ->use if-elseif-else**/
    //return value with if-elseif-else
    if (trafficLightColor == "Red") println("A_2 Stop")
    else if (trafficLightColor == "Yellow") println("A_2 Slow")
    else if (trafficLightColor == "Green") println("A_2 Go")
    else println("A_2 Not Traffic Light")

    /**A 3 -> use when statement for multiple branches **/
    when (trafficLightColor) {
        "Red" -> println("A_3 Stop")
        "Yellow" -> println("A_3 Slow")
        "Green" -> println("A_3 Go")
        else -> println("A_3 Not Traffic Light")
    }
    //multiple control
    when (trafficLightColor) {
        "Red", "Yellow", "Green" -> println("A_3 Valid Traffic Light")
        else -> println("A_3 Invalid Traffic Light")
    }
    //use when with in(multiple between) and is(type Any)

    when (number) {
        2, 3, 5, 7 -> println("A_3 number is a prime number between 1 and 10.")
        in 1..10 -> println("A_3 number is a number between 1 and 10, but not a prime number.")
        is Int -> println("A_3 number is an integer number, but not between 1 and 10.")
        else -> println("A_3 number isn't between 1 - 10")
    }

    /**A_4 -> if/else and when return different values **/
    val message = if (trafficLightColor == "Red") "A_4 Stop"
    else if (trafficLightColor == "Yellow") "A_4 Slow"
    else if (trafficLightColor == "Green") "A_4 Go"
    else "A_4 Not Traffic Light"
    println(message)

    //return value with when
    val numberMessage = when (number) {
        1, 2, 3 -> "A_4 Number 1 or 2 or 3"
        in 5..15 -> "A_4 Number 5 between 15"
        is Int -> "A_4 number but not valid number"
        else -> "A_4 Invalid"
    }
    println(numberMessage)
}