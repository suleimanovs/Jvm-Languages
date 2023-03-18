package function.inline

/**
 * Что такое noinline?
 * Предположим, что у нас есть две лямбды, такие как abc и xyz, как показано ниже:
 */

inline fun doSomethingElse1(abc: () -> Unit, xyz: () -> Unit) {
    abc()
    xyz()
}
/**
 * Использовать noinline - имеет смысл, когда одно из лямбда-выражений содержит много кода или используется так,
 * что не допускает встраивания. Соответствующие параметры можно объявить не встраиваемыми, добавив модификатор noinline:
 * Но, мы не хотим встраивать обе лямбды abc и xyz, мы хотим встроить только abc, но не xyz,
 * в этом случае нам нужно использовать noinline перед xyz, как показано ниже:
 */
inline fun doSomethingElse2(abc: () -> Unit , noinline xyz: () -> Unit) {
    println("start")
    abc()
    xyz()
    println("finish")
}

fun deSomething() {
    doSomethingElse2({ println("abc") } , { println("xyz") })
}
/**
 * Таким образом, мы можем использовать noinline, чтобы избежать подкладки.
 * Опять же, давайте посмотрим на декомпилированный код. Декомпилированный код выглядит следующим образом:
 *
 *      public static final void deSomething() {
 *          System.out.println("start");
 *          Function xyz = (new Function() {
 *              @Override
 *              public void invoke() { System.out.print("xyz");
 *              }
 *          });
 *          System.out.println("abc");
 *          xyz.invoke();
 *          System.out.println("finish");
 *          }
 *
 * Как мы видим тело функций  [doSomethingElse2] и тело лямбды abc было вставлено в [doSomething].
 * Но в случае лямбды xyz, такого не случилось, новый объект создался
 */

