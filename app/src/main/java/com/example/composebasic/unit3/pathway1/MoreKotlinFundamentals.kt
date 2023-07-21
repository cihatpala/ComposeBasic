package com.example.composebasic.unit3.pathway1

/**A-unit3-pathway1 More Kotlin fundamentals **/
//A_1 Introduction
//A_2 Generics, objects and extensions (Bkz. A_2.1, A_2.2)
//A_3 Use an enum class
//A_4 Use a data class
//A_5 Use a singleton object
//A_6 Extend classes with new properties and methods (A_6.1 -> Extend properties, A_6.2 -> Extend function)
fun main() {
    //A_2.2 Generic kullanılan classın main içinde kullanımı
    //A_3 Difficulty Enumunun kullanılması
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 =
        Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)

    //A_4 data classın
    val questionDataClass1 =
        QuestionDataClass<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val questionDataClass2 =
        QuestionDataClass<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val questionDataClass3 =
        QuestionDataClass<Int>("How many days are there between full moons?", 28, Difficulty.HARD)

    println("question1: " + question1) //Data class olmadığı için java'nın pathini yazar
//    println("questionDataClass1: " + questionDataClass1) //Data class olduğu için otomatik olarak toString yapıyor.

    //A_5 Singleton objenin main'de kullanımı
    println("${StudentProgress.answered} of ${StudentProgress.total} answered.")

    println("A_5: ${Quiz.answered} of ${Quiz.total} answered.")

    //A_6.1 Extended propertiesin main içinde kullanımı
    println("A_6.1: ${Quiz.progressText}")
    //A_6.2 Extended functionun main içinde kullanımı
    Quiz.printProgressBar()

}

//A_2.1 String cevap alan class
class FillInTheBlankQuestion(
    val questionText: String,
    val answer: String,
    val difficulty: String
)

//A_2.1 Boolean cevap alan class
class TrueOrFalseQuestion(
    val questionText: String,
    val answer: Boolean,
    val difficulty: String
)

//A_2.1 Integer cevap alan class
class NumericQuestion(
    val questionText: String,
    val answer: Int,
    val difficulty: String
)

//A_2.2 Diğer Question classlarındaki cevap veri tipinin generic olarak yapılması
class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)

//A_3
enum class Difficulty {
    EASY, MEDIUM, HARD
}

//A_4
data class QuestionDataClass<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)

//A_5
object StudentProgress {
    var total: Int = 10
    var answered: Int = 3
}


//A_5
class Quiz {
    val question1 = QuestionDataClass<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 =
        QuestionDataClass<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 =
        QuestionDataClass<Int>("How many days are there between full moons?", 28, Difficulty.HARD)

    //A_5
    companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
    }
}

//A_6.1
val Quiz.StudentProgress.progressText: String
    get() = "${answered} of ${total} answered"

//A_6.2
fun Quiz.StudentProgress.printProgressBar() {
    repeat(Quiz.answered) { print("▓") }
    repeat(Quiz.total - Quiz.answered) { print("▒") }
    println()
    println(Quiz.progressText)
}