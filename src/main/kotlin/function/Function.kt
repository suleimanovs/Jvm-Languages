package project.course.function

fun checker(num: String): Int {
    return num.length
}

fun main() {

    /**
     *  Если в методе всего лишь одно действие ,
     *  то можно опустить фигурные скобки
     **/
    fun splitter(str: String) = str.substring(0 , 5)


    /**
     *  vararg - в методе принимает не ограниченное количество аргументов(переменных)
     *  если в методе есть и другие одиночные аргументы, то следует указать vararg в конце,
     *  при вызове мы можем передать дажн массив, но нужно перед массивом поставить *
     **/
    fun sum(vararg numbers: Int): Int {
        val sum = 0
        for (i in numbers) {
            sum + i
        }
        return sum

    }


    /**
     * Функция которая принимает лямбду функцию а так же ссылку на другую функцию
     */

    fun count(firstNum: Int , check: (Int) -> Boolean , checkSimple: (Int) -> Boolean) {
        println(check(firstNum))
        println(checkSimple(firstNum))

    }
    //сокращенная форма функций
    fun checker(num: Int) = num % 2 == 0


    count(12 , ::checker , ({ it % 3 == 0 }))

    // Если лямбда функция находится последней, то вызвать можно и без курглых скобок
    count(12 , { it % 3 == 0 }, { it % 3 == 0 })


    /**
     * Обьявление функций которая возвращает функцию
     */

    fun getCapitalizeFunction(): (String) -> String = { it.replaceFirstChar { it.titlecase() } }


    /**
     * Вызвать такую функцию можно 2 способами
     */
    val name = "osman"
    println(getCapitalizeFunction()(name))

    val capitalize = getCapitalizeFunction()
    println(capitalize(name))


}