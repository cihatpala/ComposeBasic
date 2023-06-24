package com.example.composebasic.unit2.pathway1.Path4

/**A-unit2-pathway1 path4 Use classes and objects in Kotlin devamı (8. kısım)**/
//A_8 Visibility modifiers
//A_8.1 public(default modifiers)
//A_8.2 private(Aynı sınıftan veya kaynak dosyadan erişim)
//A_8.3 protected(Alt sınıftan erişim sağlanır)
//A_8.4 internal(Aynı modülde erişim sağlar)
fun main() {
    var smartTVDeviceA = SmartTVDeviceA("Android Tv", "Entertainment1")
    smartTVDeviceA.deviceStatus

    var smartLightDeviceA = SmartLightDeviceA("Smart Light", "Entertainment2")

    var smartHome = SmartHomeA(smartTVDeviceA, smartLightDeviceA)
    smartHome.turnOffTv()
    smartHome.turnOffLight()
    println("smartHome.deviceTurnOnCount -> ${smartHome.deviceTurnOnCount}")
}

open class SmartDeviceA(val name: String, val category: String) {
    /**A_8.2 SmartDeviceA'dan üretilen nesneden doğrudan erişilemez**/
    private var deviceNumber = 1

//        protected set(value) {
//            field = value
//        }
    /**A_8.3.1**/
    var deviceStatus = "online"
        protected set

    fun turnOn() {
        println("Smart device is turned on.")
    }

    open fun turnOff() { //A_7.4 -> override için açılacak fonksiyonlar "open" ile tanımlanır
        println("Smart device is turned off.")
    }
}

class SmartTVDeviceA(var deviceName: String, var deviceCategory: String) :
    SmartDeviceA(name = deviceName, category = deviceCategory) {
    var channelNumber = 0
    override fun turnOff() {
        println("SmartTVDeviceA is turned off.")
        super.turnOn()
    }

    /**A_8.3 **/
    protected fun nextChannel() {
        channelNumber++
    }
}

class SmartLightDeviceA(var deviceName: String, var deviceCategory: String) :
    SmartDeviceA(name = deviceName, category = deviceCategory) {
    override fun turnOff() {
        println("SmartLightDeviceA is turned off.")
        super.turnOn()
    }
}


class SmartHomeA(
    val smartTvDeviceA: SmartTVDeviceA,
    val smartLightDeviceA: SmartLightDeviceA
) {
    var deviceTurnOnCount = 0
        private set

    fun turnOffTv() {
        deviceTurnOnCount++ //Sadece SmartHomeA classının içinden erişilir.
        smartTvDeviceA.turnOff()
    }

    fun turnOffLight() {
        deviceTurnOnCount++
        smartLightDeviceA.turnOff()
    }
}

//Modifiers constructor'da da kullanılabilir
open class SmartDeviceX protected constructor(val name: String, val category: String) {

}

//classın da modifiers'ı olabilir.
internal open class SmartDeviceY protected constructor(val name: String, val category: String) {

}

