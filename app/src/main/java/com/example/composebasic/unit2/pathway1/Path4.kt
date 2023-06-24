package com.example.composebasic.unit2.pathway1

/**A-unit2-pathway1 path4 Use classes and objects in Kotlin**/
//A_1 Begin (Encapsulation, Abstraction, Inheritance ve Polymorphism hakkında genel bilgiler verilir.)
//A_2 Define a class
//A_3 Create an instance of a class
//A_4 Define class methods (Bkz. A_4.1 , A_4.2)
//A_5 Define class properties (Bkz. A_5.1, A_5.2, A_5.3, A_5.4, A_5.6)
//A_6 Define a constructor (Bkz. A_6.1, A_6.2, A_6.3)
//A_7 Implement a relationship between classes
fun main() {
    /**A_3 Create an instance of a class**/
    //sabit bir değer için val, değişken bir değer için var ile tanımlanır.
    //Not: val ile tanımlanan sabit değere başka nesne atanmaz ama nesne içindeki özellikler değiştirilebilir.
    val smartTvDevice = SmartDevice("Android TV", "Entertainment", 1)
    /**A_4.2 Call a method on an object**/
    smartTvDevice.turnOn()
    smartTvDevice.turnOff()

    /**A_5.2 propertieslere erişilebilir.**/
    println("Device name is: ${smartTvDevice.name}")

    /**A_5.4 speakerVolume'un set yapılmadan get yapıldı).**/
    println("Device speakerVolume 1: ${smartTvDevice.speakerVolume}")
    smartTvDevice.speakerVolume = 101
    /**A_5.5 speakerVolume'e set yapıldıktan sonraki çıktı .**/
    println("Device speakerVolume 2: ${smartTvDevice.speakerVolume}")

    /**A_6.3 ikincil constructor tanımındaki statusCode 1 setlenmesi sonrası deviceStatus kontrol ediliyor.**/
    println("A_6.3 Device deviceStatus : ${smartTvDevice.deviceStatus}")


}

/**A_2 Define a class**/
/**A_6.2 -> SmartDevice(val name: String, val category: String) **/
/**A_6.3 -> ikincil constructor (A_6.2'ü başlatması gerekiyor.) **/
class SmartDevice(val name: String, val category: String) {
    /**A_5.1 Classın propertieslerinin tanımlanması**/
    //val name = "Android TV" vs...
    var deviceStatus = "unknown"


    /**A_6.3 ikincil constructor tanımlanması**/
    constructor(name: String, category: String, statusCode: Int) : this(name, category) {
        this.deviceStatus = when (statusCode) {
            0 -> "offline"
            1 -> "online"
            else -> "unknown"
        }
    }

    /**A_5.3 getter and setter method**/
    //val değerler salt okunur olduğundan yalnızca get() metodu çalışabilir.
    //Kotlin'de bir propertis'e değer atamak için destek alan kullanılır(bunun adı field oluyor)
    //Eğer destek alan yerine doğrudan set metodu içinde speakerVolume'a değer atamaya çalışırsak sonsuz döngüye girer ve patlar.
    var speakerVolume = 2
        get() = field
        set(value) {
            /**A_5.6 speakerVolume'u doğrudan nesne üzerinden erişip "=" ifadesi ile atama yaptığımızda burası otomatik olarak çalışır
            Bu çalışma sırasında istediğimiz kontrolleri yapabileceğimiz if-when vb. kontrolleri direkt set içine yazabiliriz.**/
            field = when (value) {
                in 1..100 -> value
                else -> field
            }
        }

    /**A_4.1 Define class methods (turnOn and turnOff methods)**/
    fun turnOn() {
        println("Smart device is turned on.")
    }

    fun turnOff() {
        println("Smart device is turned off.")
    }
}

/**A_6.1 -> Default constructor**/
//Bunun ( constructor() ) yazılmasına gerek yok.
class DefaultConstructorClass constructor() {
    //...
}

/**A_6.2 -> Define a parameterized constructor**/
class ParameterizedConstructorClass(val parameter1: String, var parameter2: String) {
    //...
}