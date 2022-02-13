package project.inline

/**
 * Что такое noinline?
 * Предположим, что у нас есть две лямбды, такие как abc и xyz, как показано ниже:*/

inline fun doSomethingElse1(abc: () -> Unit, xyz: () -> Unit) {
    // I can take function
    // do something else here
    // execute the function
    abc()
    xyz()
}
/**
 * Но, мы не хотим встраивать как лямбды abc, так и xyz, мы просто хотим встроить abc, но не xyz,
 * в этом случае нам нужно использовать noinline перед xyz, как показано ниже:
 */
inline fun doSomethingElse2(abc: () -> Unit , noinline xyz: () -> Unit) {
    // I can take function
    // do something else here
    // execute the function
    abc()
    xyz()
}

fun deSomething() {
    doSomethingElse2({ println("abc") } , { println("xyz") })
}
/**
 * Таким образом, мы можем использовать noinline, чтобы избежать подкладки.
 * Опять же, давайте посмотрим на декомпилированный код. Декомпилированный код выглядит следующим
 * образом:
 *
 *      public static final void deSomething() {
 *          Function xyz = (new Function() {
 *              @Override
 *              public void invoke() { System.out.print("xyz");
 *              }
 *          });
 *          System.out.println("abc");
 *          xyz.invoke();
 *          }
 *
 */

