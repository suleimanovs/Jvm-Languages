package function

/**
 * Функции-расширения, или свойства-расширения, вызываются так же, как обычные, но определяются не внутри класса,
 * который расширяют, и не используют механизм наследования для добавления новых возможностей.
 *
 * В Java-версии байт-кода расширение Kotlin — это статический метод, который при компиляции для JVM принимает
 * объект расширяемого класса в качестве первого аргумента
 *
 * Фактически функция-расширение - это самый обычный статический метод, которому в первом аргументе
 * передается объект-приемник. Её вызов не предполагает создания объектов-адаптеров или других накладных
 * расходов во время выполнения.
 *
 *
 * Имя класса называется типом-получателем (receiver type); значение, для которого вызывается функция-расширение,
 * называется объектом-получателем (receiver object).
 */

fun Int.validNumber(): Boolean {
    return this % 2 == 0
}


/**
 * Здесь мы создали собственный with используя обобщение,
 * вместо [T] и  [U] можно указать любую букву
 */
fun <T, U> myWith(predicate: T, extension: T.() -> U): U {

    return predicate.extension()
}


/**
 * Это функция изначально была расширением Any, номы сделали его обобщенным
 * теперь его можно вызвать для любого типа
 **/
fun <T> T.easyPrint(): T {
    println(this); return this
}


val String.lastChar: Char
    get() = get(length - 1)


/**
 * тут в качестве возвращаемого не нужно указать Int
 * потому что get() и так возвращает тип Int
 * и это свойство расширения
 */
val String.isLargeString: Boolean
    get() {
        return this.length >= 10
    }

/**
 * это функция замена к стандартным shuffled().first()
 * Iterable-указан потому что обе функция являются
 * итерациями, по этому мы указали их суперип
 */
fun <T> Iterable<T>.random(): T = this.shuffled().first()
