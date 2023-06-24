package com.example.composebasic.unit2.pathway1.Path4

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**A-unit2-pathway1 path4 Use classes and objects in Kotlin devamı (9. bölüm)**/
//ReadWriteProperty bir interface ve bunun nasıl uygulandığı ile ilgili bölüm.

fun main() {
    var smartTVDeviceB = SmartTvDeviceB("Smart TV ANDROID", "Entertainment")
    smartTVDeviceB.speakerVolume = 102
    smartTVDeviceB.getSpeakerVolumeLevel() //RangeRegulator'un filtresinden geçtikten sonra
    // speakerVolume değişkenine atanan değerin geçersiz olduğu anlaşıldığı için 0 değeri basılacak
    smartTVDeviceB.channelNumber = 102
    smartTVDeviceB.getChannelNumber() //RangeRegulator'un filtresinden geçtikten sonra
    // channelNumber değişkenine atanan değerin geçerli olduğu anlaşıldığı için 102 değeri basılacaktır.
}

open class SmartDeviceB(val name: String, val category: String) {

}

class SmartTvDeviceB(deviceName: String, deviceCategory: String) :
    SmartDeviceB(name = deviceName, category = deviceCategory) {
    var speakerVolume by RangeRegulator(initialValue = 0, minValue = 0, maxValue = 100)

    fun getSpeakerVolumeLevel() {
        println("SmartTvDeviceB speaker level: $speakerVolume ")
    }

    var channelNumber by RangeRegulator(initialValue = 1, minValue = 0, maxValue = 200)

    fun getChannelNumber() {
        println("SmartTvDeviceB speaker level: $channelNumber ")

    }


}


class RangeRegulator(
    initialValue: Int,
    private val minValue: Int,
    private val maxValue: Int
) : ReadWriteProperty<Any?, Int> {
    var fieldData = initialValue
    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if (value in minValue..maxValue) {
            fieldData = value
        }
    }
}