package classes

class SomeUtil1 {

    /**
     * Вспомогательный объект объявляется внутри класса с помощью модификатора companion.
     * У класса не может быть больше одного вспомогательного объекта. Некий аналог static в Java
     *
     * Инициализация вспомогательного объекта выполняется в двух случаях: при инициализации вмещающего класса,
     * что делает его хорошим местом для хранения данных в единственном экземпляре,
     * имеющих контекстную связь с объявлением класса, и при прямом обращении к одному из его свойств или функций.
     *
     * Так как фактически вспомогательный объект — это объявление объекта, вам не придется создавать экземпляр класса,
     * чтобы использовать любые объявленные в нем функции или свойства.
     */
    companion object {

        // может иметь константы
        private const val TAG = "SomeUtil1";

        // может иметь методы
        fun load() = println("load something")

        // иметь статические блоки
        init {
            println("init block")
        }
    }

    /**
     * Object companion - компилируется в вложенный статический класс, с названием Companion, в случае если
     * мы объявили имя для companion, то будет использован оно.
     * Как мы видим создается объект этого класса в единственном экземпляре (так как поле является статическим и финальным)
     *
     * public final class SomeUtil1 {
     *     private static final String TAG = "SomeUtil1";
     *     public static final SomeUtil1.Companion Companion = new SomeUtil1.Companion();
     *     static {
     *         System.out.println("init block");
     *     }
     *     public static final class Companion {
     *
     *         public final void load() {
     *             String var1 = "load something";
     *             System.out.println(var1);
     *         }
     *         private Companion() {
     *         }
     *     }
     * }
     *
     *
     */
}

interface Printable {
    fun print()
}

class SomeUtil2 {
    /**
     * Вспомогательный объект так же может иметь имя, и наследоваться
     */
    companion object SomeUtilCompanion : Printable {
        override fun print() = println(this is Printable)
    }

    /**
     *
     * декомпилированная версия
     *
     * public final class SomeUtil2 {
     *     public static final SomeUtil2.SomeUtilCompanion SomeUtilCompanion = new SomeUtil2.SomeUtilCompanion();
     *     public static final class SomeUtilCompanion implements Printable {
     *
     *         public void print() {
     *             System.out.println(this instanceof Printable);
     *         }
     *         private SomeUtilCompanion() {}
     *     }
     * }
     */
}

fun main() {
    SomeUtil1.load()
    SomeUtil1.Companion.load()

    SomeUtil2.print()
    SomeUtil2.SomeUtilCompanion.print()
}