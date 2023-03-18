package variable


fun main() {

    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)

    /**
     * Создает обратную итерацию
     */
    for (i in 5 downTo 0) {
        println(i) //5 4 3 2 1 0
    }

    /**
     * Создает обратную итерацию шагом 2
     */
    for (i in 10 downTo 0 step 2) {
        println(i) //10 8 6 4 2 0
    }


    /**
     * итерация с помощью [Iterator]
     */
    for (i in list.iterator()) {
        println(i)
    }

    /**
     * итерация с помощью [Iterable], у которого вызывает метод [Iterable.iterator]
     */
    for (i in list) {
        println(i)
    }


    /**
     * Итерация с помощью [IntRange]
     */
    for (i in list.indices) {
        println(i)
    }


    /**
     * Итерация с помощью [Iterable] и [IndexedValue]
     */
    for ((index, element) in list.withIndex()) {

    }

    /**
     * Итерация  с помощью последовательностей [Sequence]
     */
    for (i in list.asSequence()) {

    }

    /**
     * Чтобы выполнить итерацию диапазона чисел, не включающего его конечный элемент, используйте функцию until:
     */
    for (i in 8 downTo 1 step 2) print(i)
}