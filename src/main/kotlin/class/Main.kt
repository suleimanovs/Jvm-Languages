package `class`

import project.course.oop.*
import project.course.oop.`class`.*

/**
 * @abstract - создать экземпляры абстрактного класса не получиться,
 * он предназначен только для наследования, для такого класса ключевое слово [open]
 * не требуется, это и так ясно
 */

fun main() {

    /**
     * Поскольку все они наследники Worker , то можно указать что тип содерживого Worker
     */
    val workers = listOf(
        Seller("Ivan" , 18) ,
        Seller("Osman" , 2) ,
        Seller("Alan" , 19) ,
        Director("Mik" , 50) ,
        Programmer("Ivan" , 18 , "Java") ,
        Programmer("Osman" , 21 , "Kotlin") ,
        Programmer("Alan" , 19 , "Python") ,
    )

    val cleaners = workers.filter { it is Cleaner }.map { it as Cleaner }
    for (i in cleaners) {
        i.clean()
    }


    for (i in workers) {

        /**
         * Поскольку не все  наследники Worker получили интерфейс Cleaner, нужно сделать умное
         * приведение типа(smart- cast). is так же и приводить автоматически , as нам не нужно
         */
        when (i) {
            is Seller -> i.clean()
            is Programmer -> i.clean()
        }
    }

}

