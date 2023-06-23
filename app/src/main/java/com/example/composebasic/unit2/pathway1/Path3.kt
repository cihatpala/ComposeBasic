package com.example.composebasic.unit2.pathway1

/**A-unit2-pathway1 path3 Use nullability in Kotlin**/
//A_1 Begin
//A_2 Use nullable variables
//A_3 Handle nullable variables
fun main() {
    //val ile tanımlanan değişkene sonradan değer atanamaz
    //Sonradan değer atamak istediğimiz değişkeni "var" ile tanımlarız
    //var ile düz bir şekilde tanımlanan değikene null değeri atanamaz
    /**A_2 -> nullable veriable şu şekilde belirlenir
     * var degiskenAdi : String (type)? = value **/
    var favoriteActor: String? = "Jack Nicholson"
    println("A_2 favorite actor 1: $favoriteActor")
    //null olabileceğini belirttiğimiz favoriteActor değişkenine artık null değer atayabiliriz
    favoriteActor = null
    println("A_2 favorite actor 2: $favoriteActor")
    //denememiz istenen try-it -> Int değere sahip bir değişkeni null alabilecek hale getirmek.
    var number: Int? = 10
    println("A_2 number 1 : $number")
    number = null
    println("A_2 number 2 : $number")

    /**A_3 -> ("?." kullanımı") safe-call operator **/
    //favoriteActorNullable.lenght'e direkt erişemeyiz, hata verir.
    //bu değişkenin lenghtine erişebilmemiz için ya favoriteActorNullable!=null gibi bir if yazacağız
    //ya da "?." ifadesi ile kontrol edeceğiz. aşağıdaki örnekte bu kullanıldı.
    //Not: val ile tanımlanan (dolayısıyla null atanamayan) değişkenlerin
    // lenght gibi özelliklerine erişirken de "?." kullanılabilir hata vermez fakat bu gereksizdir.
    var favoriteActorNullable: String? = "Jack Nicholson"
    println("A_3 favoriteActorNullable 1: ${favoriteActorNullable?.length}")
    favoriteActorNullable = null
    println("A_3 favoriteActorNullable 2: ${favoriteActorNullable?.length}")

    /**A_3 -> ("!!." kullanımı") not-null assertion operator **/
    var favoriteActorNull: String? = null
    //aşağıdaki print NullPointerException fırlatır çünkü "!!." ifadesi kasten null olmadığını dikte etmemizi sağlar
    // fakat favoriteActorNull değişkeni kesinlikle null''dır
//    println("A_3 favoriteActorNull 3: ${favoriteActorNull!!.length}")
    /**A_3 -> if -else ile de "?." kullanımını "degisken != null" şeklinde kullanabiliriz.**/
    //burası için örnek yazılmadı.

    /**A_3 -> ("?:" kullanımı)  Elvis operator **/
    //Basit else kullanımı sağlar
    var singer: String? = "Elvis Presley"
    println("A_3 Singer Name Lenght 1: ${singer?.length ?: 0}")
    singer = null
    println("A_3 Singer Name Lenght 2: ${singer?.length ?: "No Singer Name "}")

}