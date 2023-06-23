package com.example.composebasic.unit2.pathway1

/**A-unit2-pathway1 path4 Use classes and objects in Kotlin**/
//A_1 Begin (Encapsulation, Abstraction, Inheritance ve Polymorphism hakkında genel bilgiler verilir.)
//A_2 Define a class
//A_3 Create an instance of a class
//A_4 Define class methods (Bkz. A_4.1 , A_4.2)
//A_5 Define class properties (Bkz. A_5.1, A_5.2, A_5.3, A_5.4, A_5.6)
//A_6 Define a constructor
fun main() {
    /**A_3 Create an instance of a class**/
    //sabit bir değer için val, değişken bir değer için var ile tanımlanır.
    //Not: val ile tanımlanan sabit değere başka nesne atanmaz ama nesne içindeki özellikler değiştirilebilir.
    val smartTvDevice = SmartDevice()
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

}

/**A_2 Define a class**/
class SmartDevice {
    /**A_5.1 Classın propertieslerinin tanımlanması**/
    val name = "Android TV"
    val category = "Entertainment"
    var deviceStatus = "online"

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