package function

import kotlin.random.Random

fun checker(num: String): Int {
    return num.length
}

fun main() {


    /**
     * Функция которая принимает другую функцию(лямбду) в назвается функцией высшего порядка
     * Функциями высшего порядка называют функции, которые принимают другие функции в аргументах и/или возвращают их.
     */

    fun count(firstNum: Int, check: (Int) -> Boolean, checkSimple: (Int) -> Boolean) {
        println(check(firstNum))
        println(checkSimple(firstNum))
    }

    fun isLargeNumber(num: Int, check: (Int) -> Boolean) {
        println(check(num))
    }

    fun checker(num: Int) = num % 2 == 0


    /**
     * Можно передать ссылку на другую функцию, которая соответствует требованиям,
     * количество параметров, тип параметров, возвращаемый тип
     */
    count(12, ::checker, ::checker)
    count(12, { it % 3 == 0 }, { it % 6 == 0 })

    /**
     * Когда функция принимает другую функцию в последнем параметре, круглые
     * скобки вокруг аргумента с лямбдой можно отбросить
     */
    isLargeNumber(12) {
        12 > Random(11).nextInt()
    }


    /**
     * Объявление функций которая возвращает функцию
     * хоть мы не указали типы параметров в самой лямбде, но лямбда понимает с каким типом она будет работать,
     * эту информацию он берет сигнатуры функций, которая возвращает лямбду для String.
     */
    fun getCapitalizeFunction(): (String) -> String = { it.replaceFirstChar { it.titlecase() } }

    /**
     * хоть мы не указали какую лямбду должна вернуть функция, но функция знает какую лямбду он вернет,
     * эту информацию он берет из объявления лямбды, которая принимает String.
     */
    fun getCapitalizeFunctionFull1() = { str: String -> str.replaceFirstChar { it.titlecase() } }


    fun getCapitalizeFunctionFull2(): (String) -> String {
        return { str: String -> str.replaceFirstChar { it.titlecase() } }
    }


    /**
     * Вызвать такую функцию можно 2 способами
     */
    val name = "osman"
    println(getCapitalizeFunction()(name))

    val capitalize = getCapitalizeFunction()
    println(capitalize(name))


}