package inline

/**
 * Что такое встроенная функция?
 * Встроенная функция инструктирует компилятор вставлять полное
 * тело функций везде, где эта функция использовалась в коде.
 * Преимущества встроенной функции заключаются в следующем:
 *     - Накладные расходы на вызов функций не возникают.
 *     - Он также экономит накладные расходы переменных push/pop в стеке при вызове функции.
 *     - Это также экономит накладные расходы на обратный вызов из функции.Такая оптимизация
 *      невозможна для обычных вызовов функций
 *
 *Давайте посмотрим на этом на примере: [doSomething] - [doSomethingElse]
 */
fun doSomething() {
    print("doSomething start")
    doSomethingElse { print("doSomethingElse") }
    print("doSomething end")
}

fun doSomethingElse(abc: () -> Unit) {
    abc()
}

/**
 * Декомпилированный код примерно(очищая лищнее,обьявление класса и т.д) будет
 * выглядит следующим образом:
 *
 *   public void doSomething() {
 *       System.out.print("doSomething start");
 *       doSomethingElse(new Function() {
 *       @Override
 *       public void invoke() {
 *       System.out.print("doSomethingElse");
 *       }
 *       });
 *       System.out.print("doSomething end");
 *   }
 *       public void doSomethingElse(Function abc) {
 *       abc.invoke();
 *    }
 *
 *
 * И причем стоить отметить, если мы вызываем подобные функций множество раз, то для каждого вызова под капотом будет
 * создан объект интерфейсного типа, что является очень ресурс затратной с точки зрения Heap и Garbage Collector.
 *
 *
 *
 * Теперь попробуем добавить ключевое слово inline, как показано ниже, в функции doSomethingElse().
 */

fun doSomethingInline() {
    print("doSomething start")
    doSomethingElseInline {
        print("doSomethingElse")
    }
    print("doSomething end")
}

inline fun doSomethingElseInline(abc: () -> Unit) {
    abc()
}

/**
 * Опять же, давайте посмотрим на декомпилированный код. Декомпилированный код выглядит следующим
 * образом:
 *
 *  public void doSomething() {
 *      System.out.print("doSomething start");
 *      System.out.print("doSomethingElse");
 *      System.out.print("doSomething end");
 *  }
 *
 *
 *  Так как мы видим, что код функции doSomethingElse помещен внутри функции doSomething.
 *  Вот как inline может помочь нам сделать выполнение быстрым, избегая вызовов function.
 *  Теперь, когда мы изучили inline, мы перейдем к ключевым словам:
 *  noinline - @see NoInline.kt
 *  cross-inline - CrossInline.kt
 */


/**
 * И ещё, если функция помечена как inline, то мы не можем вывести информацию о переменноц которая хранить в себе
 * функцию(сслыку на функцию)
 */

inline fun doSomethingElseInline2(abc: () -> Unit) {

    /**
     * Так делать мы не можем, так как в этой переменной нечего не будет, после компиляций,
     * поскольку inline вырежет полное тело abc, и просто встраивать вместо вызова
     */
    //println(abc.hashCode())
    abc()
}







