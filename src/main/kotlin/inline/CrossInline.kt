package project.inline


/**
 * Что такое кросс инлайн?
 * Чтобы понять перекрестную линию, нам нужно понять «нелокальные возвраты».
 * Давайте возьмём пример, чтобы понять нелокальные возвраты.
 */

fun doSomething() {
    print("doSomething start")
    doSomethingElse {
        print("doSomethingElse")
        return // поскольку это функция будет встроена,то вызов return сработает для doSomething
    }
    print("doSomething end")
}

inline fun doSomethingElse(abc: () -> Unit) {
    // I can take function
    // do something else here
    // execute the function
    abc()
}

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
 * Нам нужно добавить кроссинлайн,тогда это не позволит нам поместить возврат внутрь, что лямбды,
 * как показано ниже:
 */

fun doSomething2() {
    print("doSomething start")
    doSomethingElse {
        print("doSomethingElse")
        // return здесь не доступен. Потому что мы пометили abc() kak crossinline
    }
    print("doSomething end")
}

inline fun doSomethingElse2(crossinline abc: () -> Unit) {
    // I can take function
    // do something else here
    // execute the function
    abc()
}
