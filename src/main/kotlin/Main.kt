import function.easyPrint

fun main() {

    val list = listOf("one", "two", "three", "four", "five", "six", "seven", "eight", "nine")

    repeat(100) {
        val item = list[it % list.size]
//        println(item)
    }
    println(0 % 5)
    println(1 % 5)
    println(2 % 5)
    println(3 % 5)
    println(4 % 5)
    println(5 % 5)
    println(6 % 5)
    println(7 % 5)
    println(8 % 5)
    println(9 % 5)
    println(10 % 5)
}