package com.example.composebasic.unit2.pathway1.Path4

/**A-unit2-pathway1 path4 Use classes and objects in Kotlin devamı (7. kısım)**/
//A_7 Classlar arası ilişkiler ve kalıtım(Bkz. A_7.1, A_7.2, A_7.3, A_7.4, A_7.5)
//A_7.2 -> IS-A ilişkisi
//A_7.3 -> HAS-A relationships
//A_7.4 -> Override (Parent classtaki kullanımı geçersiz kılıp kullanıldığı yerdekini geçerli kılar)
//A_7.5 -> "super" kullanımı
//A_7.6 -> Override ile üst sınıftaki properties(değişkenleri) geçersiz kılmak mümkündür.

fun main() {
    var smartTvDevice = SmartTVDevice("Android TV", "Entertainment")
    smartTvDevice.increaseSpeakerVolume()

    var smartLightDevice = SmartLightDevice("Android TV", "Entertainment")
    smartLightDevice.increaseBrightness()

    var smartHome = SmartHome(smartTvDevice, smartLightDevice)
    smartHome.turnOnTv()
    smartHome.turnOffAllDevices()
    smartHome.increaseLightBrightness()
}

/**A_7.1 alt sınıfların uygulayacağı class "open" ile tanımlanır**/
open class SmartDeviceGeneral(val name: String, val category: String) {
    open val deviceType = "unknown" //A_7.6 1 -> properties'i open ile override'a açarız
    fun turnOn() {
        println("Smart device is turned on.")
    }

    open fun turnOff() { //A_7.4 -> override için açılacak fonksiyonlar "open" ile tanımlanır
        println("Smart device is turned off.")
    }
}

/**A_7.2 SmartTVDevice'ın SmartDeviceGeneral classını extend etmesi**/
//Bu bir is-a ilişkisidir yani SmartTVDevice classı SmartDeviceGeneral sınıfını kalıtır.
//İlişki tek yönlüdür. her SmartTVDevice nesnesi aynı zamanda SmartDeviceGeneral nesnesi iken bunun tersi geçerli değildir.
//SmartTVDevice IS-A SmartDeviceGeneral.
class SmartTVDevice(deviceName: String, deviceCategory: String) :
    SmartDeviceGeneral(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart TV" //A_7.6 2 -> açılan properties override ile eziliyor.

    //Tüm cihazlarda volume Özelliği olmayacağından - bu sadece TV'de olacağından-
    // volume değişkeni yalnızca SmartTVDevice içinde tanımlansa yeterlidir.
    //channelNumber'da aynı şekildedir.
    var speakerVolume = 2
        set(value) {
            if (value in 0..100) {
                field = value
            }
        }
    var channelNumber = 1
        set(value) {
            if (value in 0..200) {
                field = value
            }
        }

    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Speaker volume increased to $speakerVolume.")
    }

    fun nextChannel() {
        channelNumber++
        println("Channel number increased to $channelNumber.")
    }

    override fun turnOff() { //A_7.4 -> "override" ile open olan fonksiyon ezilir.
        println("SmartTVDevice is turned off.")
        super.turnOn() //A_7.5 -> "super" ile parent classtaki turnOn() metodu olduğu gibi kullanıldı.
    }

}

//SmartLightDevice IS-A SmartDeviceGeneral.
class SmartLightDevice(deviceName: String, deviceCategory: String) :
    SmartDeviceGeneral(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart Light" //A_7.6 3 -> açılan properties override ile eziliyor.

    var brightnessLevel = 0
        set(value) {
            if (value in 0..100) {
                field = value
            }
        }

    fun increaseBrightness() {
        brightnessLevel++
        println("Brightness increased to $brightnessLevel.")
    }

    override fun turnOff() { //A_7.4 -> "override" ile open olan fonksiyon ezilir.
        println("SmartLightDevice is turned off.")
    }
}

/**A_7.3 SmartHome bir SmartTVDevice'a sahiptir.**/
// The SmartHome class HAS-A SmartTVDevice and SmartLightDevice.
class SmartHome(
    val smartTvDevice: SmartTVDevice, val smartLightDevice: SmartLightDevice
) {

    fun tvInfo() {
        println("tvInfo -> ${smartTvDevice.deviceType}")
    }

    fun smartLightInfo() {
        println("smartLightInfo -> ${smartLightDevice.deviceType}")
    }

    fun turnOnTv() {
        smartTvDevice.turnOn()
    }

    fun turnOffTv() {
        smartTvDevice.turnOff()
    }

    fun increaseTvVolume() {
        smartTvDevice.increaseSpeakerVolume()
    }

    fun changeTvChannelToNext() {
        smartTvDevice.nextChannel()
    }

    fun turnOnLight() {
        smartLightDevice.turnOn()
    }

    fun turnOffLight() {
        smartLightDevice.turnOff()
    }

    fun increaseLightBrightness() {
        smartLightDevice.increaseBrightness()
    }

    fun turnOffAllDevices() {
        turnOffTv()
        turnOffLight()
        tvInfo()
        smartLightInfo()
    }
}







