package com.example.composebasic.unit2.pathway1

import kotlin.String as String1

/**A-unit2-pathway1 Path5 -> Use function types and lambda expressions in Kotlin */
//A_1 Giriş
//A_2 Video
//A_3 Store a function in a variable (Bkz A_3.1, A_3.2, A_3.3, A_3.4, A_3.5)
//A_4 Use functions as a data type (Bkz A_4.1, A_4.2, A_4.3, A_4.4, A_4.5, A_4.6, A_4.7, A_4.8)
//A_5 Omit parameter names
//A_6 Use the repeat() function

fun main() {
    /**A_3.2 Fonksiyonlar da değişkenler gibi veri türleridir.*/
    //trick fonksiyonunu çalıştırmak yerine bir değişkene atamak fonksiyonun parantezlerini yazmayarak oluyor.
    //parantezlerini yazmadığımızda hata alırız. Hatayı engellemek için "::" ifadesini aşağıdaki gibi kullanırız.
    var trickFunction = ::trick

    /**A_3.4 lamda fonksiyonlar "::" olmadan bir değişkene atanabilir.*/
    val trickFunction1 = trick1

    //normal fonksiyon çağırımı
    trick()

    /**A_3.5 lamda'nın atandığı değişkenin çalıştırılması*/
    trickFunction1()

    /**A_4.2 normal fonksiyon gibi çağırılabilir.*/
    treat()

    /**A_4.4 dönüş olarak fonksiyon döndürme uygulaması*/
    val trickOrTreat1 = trickOrTreat(true)
    val trickOrTreat2 = trickOrTreat(false)
    trickOrTreat1()
    trickOrTreat2()

    /**A_4.7 parametre alan ve değer döndüren lambda fonksiyonun kullanımı*/
    var stringss = coins(5)
    println(stringss)

    /**A_4.8 A_4.5'te tanımlanan fonksiyonun çağırılması ve kullanılması*/
    trickOrTreatA(true, coins)

    /**A_6 pratik "for" gibi çalışır.*/
    repeat(4) {
        trickOrTreat1()
    }
    trickOrTreat2()

}

/**A_3.1 Fonksiyonlar da değişkenler gibi veri türleridir.*/
//Yani bir fonksiyon başka bir fonksiyona parametre geçilebilir ve sonrasında döndürülebilir.
//Bu işlem lambda ifadelerle mümkündür.
fun trick() {
    println("No treats1!")
}

/**A_3.3 fun ifadesinin kaldırılması ve lambda ile fonksiyon tanımlanması*/
val trick1 = {
    println("No treats2!")

}


/**A_4.1 treat fonksiyonu ile trick1 fonksiyonu bu tanımlamada aynıdır.*/
//değişkenin veri türünün Unit olarak belirtilir.
val treat: () -> Unit = {
    println("Have a treat!")
}

/**A_4.3 dönüş olarak fonksiyon döndürmek*/
fun trickOrTreat(isTrick: Boolean): () -> Unit {
    if (isTrick) {
        return trick1
    } else {
        return treat
    }
}

/**A_4.5 Bir fonksiyonu başka bir fonksiyonun değişkeni olarak atamak*/
//bir fonksiyonu parametre olarak alan fonksiyonlara high-order yani üst düzey fonksiyon denir.
fun trickOrTreatA(isTrick: Boolean, extraTreat: (Int) -> String1): () -> Unit {
    if (isTrick) {
        return trick1
    } else {
        println("extraTreat parameter -> " + extraTreat(15))
        return treat
    }
}

/**A_4.6 parametre alan ve değer döndüren lambda fonksiyon tanımları*/
val coins: (Int) -> String1 = { quantity ->
    "$quantity quarters"
}

/**A_5 lambda fonksiyonlarda "it" gelen değeri tanımlar ve doğrudan "$it" yazarak kullanabiliriz.*/
//Omit parameter names
val cupcake: (Int) -> String1 = {
    "$it Have a cupcake!"
}

