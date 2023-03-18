package variable


fun main() {

    val list = mutableListOf<Int>()
    repeat(10) { list.add(it) }

    val str = list.joinToString(separator = ";", prefix = "{", postfix = "}")
    println(str)

}


fun test() {
    /**
     * Строки неизменяемы. После инициализации строки нельзя изменить ее значение или назначить ей новое значение.
     * Все операции, преобразующие строки, возвращают свои результаты в newobject, оставляя исходную строку без изменений
     */
    val tab = "tab\ttab"
    val backspace = "backspace\bbackspace"
    val line = "line\nline"
    val r = "r\rr"

    println(tab)
    println(backspace)
    println(line)
    println(r)

    val str = "String"
    val str2 = String(charArrayOf('S', 't', 'r', 'i', 'n', 'g'))
    val str3 = "String"
    println(str == str) //true
    println(str === str) //true
    println(str == str3) //true
    println(str === str3) //true
    println(str.equals(str3)) //true

    println(str.hashCode())//-1808118735
    println(str2.hashCode())//-1808118735
    println(str3.hashCode())//-1808118735
}