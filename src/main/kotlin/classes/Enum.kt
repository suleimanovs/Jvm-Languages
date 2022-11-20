package classes

import classes.Month.*
import classes.Season.*


fun main() {

    /**
     * Для enum блок else не требуется лишь в том случае если в when перечислили всё константы.
     * Именно по этому when совместно с enum не нуждается в else.
     */

    val season = when (Month.valueOf("OCTOBER")) {
        DECEMBER, JANUARY, FEBRUARY -> WINTER
        MARCH, APRIL, MAY -> SPRING
        JUNE, JULY, AUGUST -> SUMMER
        SEPTEMBER, OCTOBER, NOVEMBER -> AUTUMN
//        else -> "Error"
    }

    println(season)

}

/**
 * @ENUM - так же может иметь параметры, в конструкторе. Каждое значение - константа, которая существует в единственном
 * экземпляре. Значение константы нельзя подстроить под конкретную ситуацию, потому что при изминении значения в одном
 * месте, оно измениться везде.
 */
enum class Month {
    JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER
}

/**
 * В Enums каждое значение должно содержать одинаковый набор свойств.
 * Не получится какому - либо значению задать дополнительные свойства.
 */
enum class Season(val number: Int) {
    WINTER(1), SPRING(2), SUMMER(3), AUTUMN(4) , // SOME(1,"some") - Error
}