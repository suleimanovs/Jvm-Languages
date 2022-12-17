package classes

import java.io.Serializable
import javax.xml.crypto.Data


/**
 * Если вам необходим один экземпляр с непротиворечивым состоянием, существующий на протяжении всего времени
 * работы программы, объявите синглтон. Экземпляр такого класса будет создан автоматически при первом обращении
 * к нему. Этот экземпляр будет существовать на всем протяжении работы программы, и при каждом следующем обращении
 * будет возвращаться первоначальный экземпляр.
 *
 * Есть три способа применения ключевого слова object: для создания объявлений объектов (синглтонов), анонимных объектов
 * и вспомогательных объектов.
 */


// создание синглтона
object Database : Iterable<String> {

    val data = arrayOf("some1", "some2", "some3", "some4", "some5")


    override fun iterator(): Iterator<String> {

        // создание анонимного объекта
        return object : Iterator<String> {

            var index = 0

            override fun hasNext() = data.getOrNull(index) != null

            override fun next() = data[index++]

        }

    }


    /**
     * Он так же может иметь свои методы, свои init блоки (они статические), и другие object-ты
     */
    fun function() = println("function")


    init {
        println("init")
    }

    object InnerObject {
        fun function() = println("inner function")
    }

    const val DATABASE_NAME = "my.bd" //иметь константы


}


/**
 * Можно внутри одного класса объявить множество объектов. Декомпилированный код класса:
 * В случае обычных object генерируется поле с названием INSTANCE, и каждый раз когда м хотим обратиться к объекту
 * через SomeKClass.Empty под капотом такое обращение SomeKClass.Empty.INSTANCE;
 *
 * public final class SomeKClass {
 *     public static final class Inner implements Serializable {
 *         public static final SomeKClass.Inner INSTANCE;
 *         public final void todo() {
 *             System.out.println();
 *         }
 *         private Inner() {}
 *         static {
 *             INSTANCE = new SomeKClass.Inner();
 *         }
 *     }
 *     public static final class Empty {
 *         public static final SomeKClass.Empty INSTANCE;
 *         private Empty() {}
 *         static {
 *             INSTANCE = new SomeKClass.Empty();
 *         }
 *     }
 * }
 */
class SomeKClass {

    object Inner : Serializable {
        fun todo() = println()
    }

    object Empty

}

fun main() {
    SomeKClass.Empty
}

