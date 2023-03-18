package variable

data class User(val name: String, val age: Int)


/**
 * Обеспечить поддержку Мультидекларации для обычных классов
 */
class Some(val name: String, val age: Int) {
    operator fun component1() = name
    operator fun component2() = age
}


fun main() {

    /**
     * Мультидекларации (destructuring declarations) позволяют распаковать одно составное значение в несколько переменные
     */

    val (name, age) = User("Osman", 20)
    println("$name $age")

    val (name2, age2) = Some("Osman", 20)
    println("$name $age")

    val (element1, element2) = listOf("Str1", "Str2")
    println("$element1 $element2")

}