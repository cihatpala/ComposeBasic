package com.example.composebasic.unit2.pathway1.practices

//The exact number of notifications when there are less than 100 notifications.
//99+ as the number of notifications when there are 100 notifications or more.
fun main() {
    val morningNotification = 51
    val eveningNotification = 135

    printNotificationSummary(morningNotification)
    printNotificationSummary(eveningNotification)
}


fun printNotificationSummary(numberOfMessages: Int) {
    val notificationMessage =
        if (numberOfMessages <= 99 && numberOfMessages >= 1) "You have $numberOfMessages notifications."
        else if (numberOfMessages >= 100) "Your phone is blowing up! You have 99+ notifications."
        else "Invalid message"

    println(notificationMessage)
}