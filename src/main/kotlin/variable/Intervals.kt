package variable


fun main() {

    /**
     * оператор (..) так же известный как [Int.rangeTo] возвращает объект типа [IntRange]
     */
    val list = (1..10).toList() // 1 и 10 включительно
    val range = 12..19

    for (i in list) {
        println(i)
    }
    for (i in range) {
        println(i)
    }

    /**
     * [Int.downTo] выполняет итеарцию назад с указанным шагом
     */
    val rangeReverse = 1 in 3 downTo 1

    /**
     * CharRange - выполняет итерацию в ASCII
     */
    for (i in 'A'..'Z'){
        println(i)
    }

    val until = 1 in 10 until 3

}