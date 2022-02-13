package project.course.function

fun main() {


    /**
     * Это лямбда функция, короткая версия
     */
    val anonymShort = { a: Int , b: Int -> a + b }


    /**
     * Это лямбда функция, полная версия, но можем указать и не явно
     */
    /*val anonymFull: (Int, Int)-> Int = { a , b-> a + b }*/
    val anonymFull: (Int , Int) -> Int = { a: Int , b: Int -> a + b }


    /**
     * Это аноним функция, полная версия, но можем указать и не явно
     */

    var anonymFunc = fun(x: Int , y: Int): Int = x + y


}