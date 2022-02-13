package course

/**
 * Created by user on 13:53
 */

/**
 * @typealias - позволяет задать некое имя для каких то там типов и т.д
 */
typealias Refactor = (Int , Int) -> Int

typealias Predicate<T> = (T) -> Boolean


fun main() {

    // with typealias
    fun sorted(num1: Int , num2: Int , predicate: Refactor): Int {
        return predicate.invoke(num1 , num2)
    }

    /** with out typealias
      fun sorted(num1: Int , num2: Int , predicate: (Int , Int) -> Int): Int {
        return predicate.invoke(num1 , num2)
    }
     */


    val result = sorted(13 , 16) { p1 , p2 ->
        if (p1 > p2) p1 else p2
    }

}



