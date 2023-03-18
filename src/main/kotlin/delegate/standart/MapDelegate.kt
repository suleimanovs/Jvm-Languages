package delegate.standart

/**
 * Delegate map - доступен только для val свойств
 */
class Pet(val map: Map<String, Any?>) {
    val name: String by map
    val age: Int by map
    val some: String by map
}

fun main() {

    val pet = Pet(mapOf("name" to "Axel", "age" to 3,"some" to "Some"))

    println(pet.name) // Prints "Axel"
    println(pet.age)  // Prints 3
    println(pet.some)  // Prints 3
}