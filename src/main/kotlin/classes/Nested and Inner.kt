package classes

import classes.OuterNested.Nested

/**
 * Created by IntelliJ IDEA: osmanboy on 1/24/2022
 */

/**
 * Это вложенный класс, или как говорят [Nested] класс. Такой запись, то есть объявление
 * равно сильно - public static final class Nested в Java
 */
class OuterNested {
    private val bar: Int = 1

    class Nested {
        /**
         * Мы не можем обращаться к свойству [bar], потому что этот класс
         * для OuterNested как static. Для доступа к этому классу мы не обязаны создать
         * объект [OuterNested]
         */
        fun foo() = 2
    }

    /**
     * Пример на Java:
     *
     *
     *       final class OuterJavaNested {
     *          private final int bar = 1;
     *          public static final class Nested {
     *              public final int foo() {
     *                  return 2;
     *              }
     *          }
     *      }
     */
}


/**
 * Это внутренний класс, или как говорят [Inner] класс. Такой запись, то есть объявление
 * равно сильно - public final class Inner в Java.
 * Для того что бы класс стал внутренним его нужно пометить ключевым словом [inner]
 */
class OuterInner {
    private val bar: Int = 1

    inner class Inner {
        /**
         * Тут мы можем обращаться к свойству [bar], потому что этот класс * для OuterInner внутренний, это часть его.
         * Для доступа к этому классу мы должны создать объект [OuterInner]
         */
        fun foo() = bar
    }


    /**
     * Пример на Java:
     *
     *
     *       final class OuterJavaInner {
     *          private final int bar = 1;
     *          public final class Inner {
     *              public final int foo() {
     *                  return OuterJavaInner.this.bar;
     *              }
     *          }
     *      }
     */
}


fun main() {
    OuterInner().Inner().foo() // == 1

    OuterNested.Nested().foo() // == 2
}
