package variable

fun main() {

    /**
     * Kotlin поддерживает автоматическое определение типов,
     * что позволяет опустить типы для переменных, которым присваиваются значения при объявлении
     */
    val one: Int = 1
    val two = 2 // auto detect

    val list1: MutableList<String> = mutableListOf<String>()
    list1.add("Str1")

    val list2 = mutableListOf("Str1", "str2") // auto detect

}