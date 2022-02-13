package project.course

import java.lang.Exception

fun main() {

    fun sum(a: String, b: String): Int{


        return try{
            a.toInt() + b.toInt()
        }
        catch (e: Exception){
            /**
             * Возвращается лишь последний элемент, в нашем случае 0
             * */
            println("Поймана ошибка - ${e.message}")
            0
        }
    }

    print(sum("e","10"))
}