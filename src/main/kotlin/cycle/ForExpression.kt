package cycle


fun main() {
    alarm2(10, 4)
}

/**
 * способ с помощью expression-ов, этот способ более правильный и рекомендуемый
 */
fun alarm2(h: Int, m: Int) {
    OUTER@ for (hour in 0..23) {
        for (minute in 0..59) {
            println("$hour : $minute")
            if (hour == h && minute == m) {
                println("Будильник звенит!")
                break@OUTER  // этот break остановит внешний loop
            }
        }
    }
}
