package function.inline


/**
 * Что такое кросс инлайн?
 * Чтобы понять перекрестную линию, нам нужно понять «нелокальные возвраты».
 * Давайте возьмём пример, чтобы понять нелокальные возвраты.
 */

//fun doSomething() {
//    print("doSomething start")
//    doSomethingElse {
//        print("doSomethingElse")
//        return // поскольку это функция будет встроена,то вызов return сработает для doSomething
//    }
//    print("doSomething end")
//}

//inline fun doSomethingElse(abc: () -> Unit) {
//    abc()
//}

/**
 * Опять же, давайте посмотрим на декомпилированный код. Декомпилированный код выглядит следующим образом:
 *
 *      public void doSomething() {
 *       System.out.print("doSomething start");
 *       System.out.print("doSomethingElse");
 *      }
 *
 * Здесь мы видим, что нет System.out.print("doSomething end").
 * Поскольку мы добавили возврат внутри лямбд, он разрешил нелокальные возвраты и оставил код под ним.
 * Как этого избежать?
 * Нам нужно добавить кроссинлайн,тогда это не позволит нам поместить возврат внутрь лямбды,
 * как показано ниже:
 */

fun doSomething2() {
    println("doSomething start")
    doSomethingElse2 {
        println("doSomethingElse")
        // return здесь не доступен. Потому что мы пометили abc() kak crossinline
        return@doSomethingElse2 // но так делать можно, с меткой
    }
    println("doSomething end")
}

inline fun doSomethingElse2(crossinline abc: () -> Unit) {
    abc()
}

fun main() {
    doSomething2()
}

