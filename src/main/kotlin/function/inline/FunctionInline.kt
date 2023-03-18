package function.inline

/**
 * Что такое inline(встроенная) функция?
 * Лямбды полезны, потому что дают больше свободы при написании программ. Но вы объявляете лямбду,
 * она представляется в JVM экземпляром объекта. JVM также выделяет память для всех переменных, доступных в лямбде,
 * а это увеличивает расход памяти. Проще говоря, лямбды очень не эффективно расходуют память,
 * что сказывается на производительности. Встраивание избавляет JVM от необходимости использовать экземпляр объекта
 * и выделять память для переменных в лямбде
 *
 * Когда функция помечена inline, вместо вызова экземпляром объекта лямбды, компилятор «скопирует и вставит» тело функции
 * туда, откуда произведен вызов. Встроенная функция инструктирует компилятор вставлять полное тело функций везде,
 * где эта функция использовалась в коде.
 *
 * Преимущества встроенной функции заключаются в следующем:
 *     - Накладные расходы на вызов функций не возникают.
 *     - Он также экономит накладные расходы переменных push/pop в стеке при вызове функции.
 *     - Это также экономит накладные расходы на обратный вызов из функции. Такая оптимизация
 *      невозможна для обычных вызовов функций
 *
 * Кроме того, принимая решение об использовании модификатора inline, не нужно забывать о размере кода.
 * Если функция, которую вы собираетесь объявить встраиваемой, достаточно велика, копирование её байт-кода во все
 * точки вызова может существенно увеличить общий размер байт-кода.
 * Давайте посмотрим на этом на примере: [doSomething] - [doSomethingElse]
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
 * Декомпилированный код примерно буде выглядит следующим образом:
 *
 *   public void doSomething() {
 *
 *       System.out.print("doSomething start");
 *
 *       doSomethingElse(new Function() {
 *       @Override
 *       public void invoke() {
 *       System.out.print("doSomethingElse");
 *       }
 *       });
 *
 *       System.out.print("doSomething end");
 *   }
 *       public void doSomethingElse(Function abc) {
 *       abc.invoke();
 *
 *    }
 *
 *
 * И причем стоить отметить, если мы вызываем подобные функций множество раз, то для каждого вызова под капотом будет
 * создан объект интерфейсного типа, что является очень ресурс затратной с точки зрения Heap и Garbage Collector.
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
    println("before lambda")
    abc()
    println("after lambda")
}

/**
 * Опять же, давайте посмотрим на декомпилированный код. Декомпилированный код выглядит следующим
 * образом:
 *
 *  public void doSomething() {
 *      System.out.println("doSomething start");
 *      System.out.println("before lambda");
 *      System.out.println("doSomethingElse");
 *      System.out.println("after lambda");
 *      System.out.println("doSomething end");
 *  }
 *
 *
 * Обратите внимание, что вместо вызова функции [doSomethingElseInline] в [doSomethingInline] было вставлено
 * тело [doSomethingElseInline] вместе с лямбдой, благодаря чему отпала необходимость передавать
 *  лямбду (и создавать еще один экземпляр объекта)
 *Обратите внимание, что встраивание применяется не только к реализации функции [doSomethingElseInline], но и к
 * телу лямбда-выражения.
 * Чтобы гарантировать высокую производительность, вы должны следить за размерами встраиваемых функций.
 * Если функция становится слишком большой, то лучше выделить из неё фрагмент, не зависящий от овеществляемых
 * типовых параметров, и превратить его в отдельную, не встраиваемую функцию
 *
 *
 *  Вот как inline может помочь нам сделать выполнение быстрым, избегая вызовов function.
 *  Теперь, когда мы изучили inline, мы перейдем к ключевым словам:
 *  @see NoInline.kt - noinline
 *  @see CrossInline.kt -cross-inline
 */


/**
 * И ещё, если функция помечена как inline, то мы не можем вывести информацию о переменной которая хранить в себе
 * функцию(сслыку на функцию)
 */

inline fun doSomethingHashcode(abc: () -> Unit) {

    /**
     * Так делать мы не можем, так как в этой переменной нечего не будет, после компиляций,
     * поскольку компилятор вырежет полное тело abc, и просто встраивать вместо вызова.
     * То есть никакой передачи аругмента не будет
     */
//    println(abc.hashCode())
}

fun doSomethingHashcode2(abc: () -> Unit) {
    println(abc.hashCode())
}