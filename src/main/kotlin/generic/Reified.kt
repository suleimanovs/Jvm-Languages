package generic

/**
 * Иногда полезно знать конкретный тип обобщенного параметра. Сделать это можно с помощью ключевого слова reified.
 * Kotlin обычно запрещает проверку типа Т, потому что обобщенные типы подвержены эффекту стирания типов — это значит,
 * что информация о типе Т недоступна во время выполнения. В Java тоже есть такое правило.
 */

fun <R> Iterable<*>.filterIsInstance(): List<R> {
    val destination = ArrayList<R>()
    for (element in this) {
        /**
         * Такую проверку компилятор не позволит сделать, обобщенные типы стираются во время выполнения.
         * Но если параметризованный тип объявить как reified, а функцию сделать встраиваемой (inline), то такая
         * проверка будет возможной
         */
        //  if (element is R) {
        //      destination.add(element)
        //  }
    }
    return destination
}


inline fun <reified R> Iterable<*>.filterIsInstance2(): List<R> {
    val destination = ArrayList<R>()
    for (element in this) {
        /**
         * Информация об обобщенном типе, которая обычно стирается, теперь * сохраняется, чтобы компилятор мог
         * проверить тип обобщенного параметра. Использование ключевого слова reified позволяет исследовать
         * тип обобщенного параметра без применения рефлексии (определение имени или типа свойства,
         * или функции во время выполнения программы обычно является ресурсоемкой операцией)
         */
        if (element is R) {
            destination.add(element)
        }
    }
    return destination
}


fun main() {
    val any = listOf("String", 2, 34f, 's', "str", 54, "str2")
    any.filterIsInstance2<String>()
    /**
     * Как работает этот механизм? Почему во встраиваемых функциях допускается проверка element is т,
     * а в обычных классах или функциях - нет? Для встраиваемых функций компилятор вставляет байт-код с их реализацией в
     * точки вызова. Каждый раз, когда в программе встречается вызов функции с овеществляемым типовым параметром,
     * компилятор точно знает, какой тип используется в качестве
     * типового аргумента для данного конкретного вызова. Соответственно, компилятор может
     * сгенерировать байт-код, который ссылается на конкретный класс, указанный в типовом
     * аргументе. В результате для вызова filterIsInstance2<String>, генерируется код, эквивалентный следующему:
     *      for (element in this) {
     *          if (element is String) {
     *             destination.add(element)
     *          }
     *      }
     *
     *Так как байт-код ссылается на конкретный класс, а не на типовой параметр, типовой аргумент не стирается во
     * время выполнения. Обратите внимание, что встраиваемые функции с овеществляемыми типовыми параметрами не могут быть
     * вызваны из Java. Обычные встраиваемые функции можно вызвать из Java, но только как функции без встраивания.
     * Напротив, функции с овеществляемыми параметрами типов требуют дополнительной обработки для подстановки значения
     * типовых аргументов в байт-код, и поэтому они всегда должны быть встраиваемыми.
     * А это делает невозможным их вызов таким способом, как это делает код на Java.
     */
}






