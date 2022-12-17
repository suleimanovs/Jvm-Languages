package function

fun main() {

    val list = listOf("Osman", "Alisa", "John", "Bob")

    localReturn(list)
    unLocalReturn(list)
    unLocalReturn2(list)
}

/**
 * Так как [forEach]является inline функцией, и ее тело будет встроено, то return будет вызван локально для [localReturn]
 * и нелокально для [forEach]
 * И мы выйдем из метода
 */

fun localReturn(list: List<String>) {
    println("start localReturn")
    list.forEach {
        if (it == "John") return
    }
    println("finish localReturn")
}


/**
 * Лямбда-выражения поддерживают также локальный возврат. Локальный возврат в лямбда-выражении напоминает
 * своим действием выражение break в цикле for. Он прерывает работу лямбда-выражения и продолжает выполнение с инструкции,
 * следующей сразу за вызовом лямбда-выражения. Чтобы отличить локальный возврат от нелокального, используются метки.
 * Можно отметить лямбда-выражение, из которого требуется произвести выход, и затем сослаться на метку в выражении return.
 *
 * Вариант метки по дефолту:
 * return будет вызван нелокально для [unLocalReturn] и локально для [forEach]
 */
fun unLocalReturn(list: List<String>) {
    println("start unLocalReturn")
    list.forEach {
        if (it == "John") return@forEach
    }
    println("finish unLocalReturn")
}

/**
 * return будет вызван нелокально для [unLocalReturn2] и локально для [forEach]
 * Вариант явного объявления метки и возврата:
 */
fun unLocalReturn2(list: List<String>) {
    println("start unLocalReturn2")
    list.forEach fuck@{
        if (it == "John") return@fuck
    }
    println("finish unLocalReturn2")
}


/**
 * Внутри анонимной функции выражение return без метки выполнит выход из анонимной функции, а не из внешней.
 * Здесь действует простое правило: return производит выход из ближайшей функции, объявленной с
 * помощью ключевого слова fun. Лямбда-выражения определяются без ключевого слова fun, поэтому return
 * в лямбда-выражениях производит выход из внешней функции. Анонимные функции объявляются с помощью fun;
 *  * return будет вызван нелокально для [nonLocal] и локально для анонимной функций внутри [forEach]
 */
fun nonLocal(list: List<String>) {
    println("start localReturn")
    list.forEach(fun(person) {
        if (person == "John") return // вызывается для анонимной функций, forEach до кона выполнит свою работу
        println("$person is not John")
    })
    println("finish localReturn")
}