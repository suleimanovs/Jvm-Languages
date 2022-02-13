package course

/** в большинство случаев деструктизацию поддерживает только data классы,
 *но о так же и словари тоже, то есть Pair(key: value)
 */
private class Worker(val name: String , val age: Int) {
    operator fun component1() = name
    operator fun component2() = age
}

fun main() {

    val pair = "Osman" to "18 age"
    val (keys , values) = pair
}
