package project.course.function

fun main() {
    /**
     * [`Extension Function`] - функций рассщирений , которые позволяеют рассщирить любой класс и тип
     * проверка на четность с помощью [Extensions]
     * в [Extensions] для обращения к вызоваемому объекту нужно использовать [this]
     * коротий способ следуюущего метода -   fun Int.validNumber2()= this % 2== 0
     */

    fun Int.validNumber(): Boolean {
        return this % 2 == 0
    }


    /**
     * проверка на простое число, число которое делиться без остатка на 1 и на себя
     */
    fun Int.checkSimple(): Boolean {
        if (this <= 3) return true
        for (i in 2 until this) if (this % i == 0) return false

        return true
    }


    /**
     * Здесь мы создали собственный with используя обобщение,
     * вместо [T] и  [U] можно указать любую букву
     */
    fun <T , U> myWith(predicate: T , extension: T.() -> U): U {

        return predicate.extension()
    }

    /*fun lister(list: MutableList<Int>, extend: MutableList<Int>.()-> MutableList<Int>){
        list.extend()
    }


    lister(arrayListOf(1,3,4,5,6,7),({
        this.reversed() as MutableList<Int>
    }))*/


    val prime = 13
    println(prime.isPrime(::isPrm))


}


/**

 * функция repeat выполняет часть кода столько раз сколько указано
 * а так же я указал прамаетры по умолчанию
 * и вызвать его мы можем только для типа String, для других типов
 * не аоддерживается, даже для Any

 **/
fun String.addEnthusiasm(count: Int = 1): String {
    return this + "!".repeat(count)
}


//возврашает последний элемент(рассширений функций)
fun String.lastChar(): Char = this[length - 1]

//возваращает последний элемент (рассширений свойтсва)
val String.firstChar: Char
    get() = get(length - 1)

val isOdd:Int.()->Boolean = { this % 2 == 0 }
val isEven:Int.()->Boolean= { this % 2 != 0 }


/**
 * Это функция изначально была расширением Any, номы сделали его обобщенным
 * теперь его можно вызвать для любого типа
 **/
fun <T> T.easyPrint(): T {
    println(this); return this
}


/**
 * тут в качестве возвращаемого не нужно указать Int
 * потому что get() и так возвращает тип Int
 * и это свойство расширения
 */
val String.Count: Int
    get() = count { "aeiouy".contains(it.toLowerCase()) }


/**
 * тут приведение типа, если оно не null то вернуть его
 * а если null то вернуть default-ное значение
 */
fun String?.stringNull(default: String = "Default") {
    println(this ?: default)
}


/**
 * это функция замена к стандартным shuffled().first()
 * Iterable-указан потому что обе функция являются
 * итерациями, по этому мы указали их суперип
 */
fun <T> Iterable<T>.random(): T = this.shuffled().first()


/**
 * и так, данное расширение  Int, делить каждое число на чисел из диопозона от (2 до нашего числа (не включая его))
 */

fun isPrm(int: Int): Boolean {
    (2 until int).map {
        if (int % it == 0) {
            return false
        }
    }
    return true
}

fun Int.isPrime(count: Int.() -> Boolean): Boolean {
    return count()
}

fun Int.isPrime(): Boolean {
    (2 until this).map {
        if (this % it == 0) {
            return false //не простое
        }
    }
    return true
}

