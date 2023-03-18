package interview


/**
 * Anonym Function(лямбда) - это функций обьявленные без имени, отличие от именнованных, анонимные
 * функций не получают имени при обьявлений, они так же возвращают последнее значение в теле без
 * необходимости в слове [return]
 */
//нечего не принимает, и нечего не возвращает
val x: () -> Unit = { println("Hello!") }
