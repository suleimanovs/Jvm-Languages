package course

import java.util.*

/**
 * Created by IntelliJ IDEA.
 * Author: osmanboy
 * Date: 1/23/2022
 * Time: 12:26 PM
 * Project name: Jvm-Languages
 */

class Dog {
    var name: String = ""
        get() = field.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }

    var age: Int = 0
        set(value) {
            if (value >= 0) field = value
        }
}

fun main() {
    val dog = Dog()
    dog.name = "Osman"
    dog.age = 100
    println(" name:${dog.name} age: ${dog.age}")
}