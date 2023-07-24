package com.example.composebasic.unit3.pathway1.path4

/** unit3-pathway1 More Kotlin fundamentals **/
/** Path4-A Higher-order functions with collections **/
//A_1 Introduction
//A_2 forEach() and string templates with lambdas
//A_3 map()
//A_4 filter()
//A_5 groupBy()
//A_6 fold()
//A_7 sortedBy()
fun main() {
//Loop over a list with forEach()
    println("\n*********** A_2 ***********\n")
    cookies.forEach {
        println("Menu item: ${it.name}")
    }

    println("\n*********** A_3 ***********\n")
    fullMenu.forEach { println(it) }

    println("\n*********** A_4 ***********\n")
    println("Soft cookies:")
    softBakedMenu.forEach {
        println("${it.name} - $${it.price}")
    }
    println("\n*********** A_5 ***********\n")
    val softBakedMenu = groupedMenu[true] ?: listOf()
    val crunchyMenu = groupedMenu[false] ?: listOf()
    println("Soft cookies with groupBy:")
    softBakedMenu.forEach {
        println("${it.name} - $${it.price}")
    }
    println("\nCrunchy cookies with groupBy:")
    crunchyMenu.forEach {
        println("${it.name} - $${it.price}")
    }

    println("\n*********** A_6 ***********\n")
    println("Total price: $${totalPrice}")

    println("\n*********** A_7 ***********\n")
    println("Alphabetical menu:")
    alphabeticalMenu.forEach {
        println(it.name)
    }
}


//A_2
class Cookie(
    val name: String,
    val softBaked: Boolean,
    val hasFilling: Boolean,
    val price: Double
)

//A_2
val cookies = listOf(
    Cookie(
        name = "Chocolate Chip",
        softBaked = false,
        hasFilling = false,
        price = 1.69
    ),
    Cookie(
        name = "Banana Walnut",
        softBaked = true,
        hasFilling = false,
        price = 1.49
    ),
    Cookie(
        name = "Vanilla Creme",
        softBaked = false,
        hasFilling = true,
        price = 1.59
    ),
    Cookie(
        name = "Chocolate Peanut Butter",
        softBaked = false,
        hasFilling = true,
        price = 1.49
    ),
    Cookie(
        name = "Snickerdoodle",
        softBaked = true,
        hasFilling = false,
        price = 1.39
    ),
    Cookie(
        name = "Blueberry Tart",
        softBaked = true,
        hasFilling = true,
        price = 1.79
    ),
    Cookie(
        name = "Sugar and Sprinkles",
        softBaked = false,
        hasFilling = false,
        price = 1.39
    )
)

//A_3
val fullMenu = cookies.map {
    "${it.name} - $${it.price}"
}


//A_4
val softBakedMenu = cookies.filter {
    it.softBaked
}

//A_5
val groupedMenu = cookies.groupBy { it.softBaked }

//A_6
val totalPrice = cookies.fold(0.0) { total, cookie ->
    total + cookie.price
}

//A_7
val alphabeticalMenu = cookies.sortedBy {
    it.name
}
