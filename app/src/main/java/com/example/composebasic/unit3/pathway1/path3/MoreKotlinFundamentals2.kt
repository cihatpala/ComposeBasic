package com.example.composebasic.unit3.pathway1.path3

/** unit3-pathway1 More Kotlin fundamentals **/
/** Path3-A Use collections in Kotlin **/
//A_1 Introduction
//A_2 Arrays in Kotlin
//A_3 Lists (Bkz A_3.1, A_3.2)
//A_4 Sets
//A_5 Map collection

fun main() {

    //A_2 Array tanımlanması
    println("\n*********** A_2 ***********\n")
    val rockPlanets = arrayOf<String>("Mercury", "Venus", "Earth", "Mars")
    val gasPlanets = arrayOf("Jupiter", "Saturn", "Uranus", "Neptune")
    val solarSystem = rockPlanets + gasPlanets
    println("A_2 ${solarSystem[0] + " " + solarSystem[4]}")
    solarSystem[4] = "Little Earth"
    println("A_2 ${solarSystem[4]}")

    //A_3.1 List
    println("\n*********** A_3.1 ***********\n")
    val solarSystemList =
        listOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    println("solarSystemList size: ${solarSystemList.size}")
    println("solarSystemList get: ${solarSystemList.get(3)}")
    println("solarSystemList indexOf: ${solarSystemList.indexOf("Neptune")}")
    println("solarSystemList indexOf non-element: ${solarSystemList.indexOf("Pluto")}")
    for (s in solarSystemList) {
        println("${solarSystemList.indexOf(s)} -> $s")
    }
    //A_3.2 MutableList
    println("\n*********** A_3.2 ***********\n")
    val solarSystemMutableList = mutableListOf<String>(
        "Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"
    )
    //Add elements to a list
    solarSystemMutableList.add(3, "Theia")
    solarSystemMutableList.add("Pluto")
    //Update elements at a specific index
    solarSystemMutableList[3] = "Future Moon"
    //Remove elements from a list
    solarSystemMutableList.removeAt(9)
    solarSystemMutableList.remove("Future Moon")
    for (s in solarSystemMutableList) {
        println("${solarSystemMutableList.indexOf(s)} -> $s")
        println("Earth" in solarSystemMutableList)
    }

    //A_4 Sets
    println("\n*********** A_4 ***********\n")
    //Use a MutableSet in Kotlin
    val solarSystemMutableSet =
        mutableSetOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    println(solarSystemMutableSet.size)
    solarSystemMutableSet.add("Pluto")
    println(solarSystemMutableSet.size)
    println(solarSystemMutableSet.contains("Pluto"))
    solarSystemMutableSet.add("Pluto") //Pluto zaten mutableSet'te olduğundan tekrar eklemez.
    println(solarSystemMutableSet.size)
    solarSystemMutableSet.remove("Pluto")
    println(solarSystemMutableSet.contains("Pluto"))
    println(solarSystemMutableSet.size)

    //A_5 Map collection
    println("\n*********** A_5 ***********\n")
    val solarSystemMutableMap= mutableMapOf(
        "Mercury" to 0,
        "Venus" to 0,
        "Earth" to 1,
        "Mars" to 2,
        "Jupiter" to 79,
        "Saturn" to 82,
        "Uranus" to 27,
        "Neptune" to 14
    )
    println(solarSystemMutableMap.size)
    solarSystemMutableMap["Pluto"] = 5
    println(solarSystemMutableMap.size)
    println(solarSystemMutableMap["Pluto"])
    println(solarSystemMutableMap.get("Theia"))
    solarSystemMutableMap.remove("Pluto")
    println(solarSystemMutableMap.size)
    solarSystemMutableMap["Jupiter"] = 78
    println(solarSystemMutableMap["Jupiter"])

}