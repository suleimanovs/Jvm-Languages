package delegate.delegates.kotlin

/**
 * Created by osmanboy on 2/12/2022
 *  Шаблон делегирования является хорошей альтернативой наследованию,
 * и Kotlin поддерживает его нативно, освобождая вас от необходимости написания шаблонного кода.
 * Класс Derived может реализовать интерфейс Base, делегировав все свои public члены указанному объекту.
 */

object Example1 {

    interface Base {
        fun print()
    }

    class BaseImpl(val x: Int) : Base {
        override fun print() = print(x)
    }

    class Derived1(b: Base) : Base by b



        @JvmStatic
        fun main(args: Array<String>) {
            val b = BaseImpl(10)
            Derived1(b).print()
        }
}


//EXAMPLE 2

/**
 * Ключевое слово by в оглавлении Derived, указывает, что b будет храниться внутри экземпляра Derived,
 * и компилятор сгенерирует все методы из Base, которые при вызове будут переданы объекту b.
 * Переопределение члена интерфейса, реализованного делегированием
 * Переопределения работают так, как вы ожидаете: компилятор будет использовать ваши override реализации
 * вместо реализаций в объекте делегата. Если вы хотите добавить override fun printMessage() {  print("abc") }
 * в Derived, программа будет печатать abc вместо 10 при вызове printMessage.
 */

object Example2 {
    interface Base {
        fun printMessage()
        fun printMessageLine()
    }

    class BaseImpl(val x: Int) : Base {
        override fun printMessage() {
            print(x)
        }

        override fun printMessageLine() {
            println(x)
        }
    }

    class Derived(b: Base) : Base by b {
        override fun printMessage() {
            print("abc")
        }
    }


    @JvmStatic
    fun main(args: Array<String>) {
        val b = BaseImpl(10)
        Derived(b).printMessage()
        Derived(b).printMessageLine()
    }
}

/**
 * Однако обратите внимание, что члены, переопределенные таким образом, не вызываются из членов делегата,
 * который может получить доступ только к своим собственным реализациям членов интерфейса.
 */

interface Base {
    val message: String
    fun print()
}

class BaseImpl(val x: Int) : Base {
    override val message = "BaseImpl: x = $x"
    override fun print() {
        println(message)
    }
}

class Derived(b: Base) : Base by b {
    // Это свойство недоступно из `b` реализации `print`.
    override val message = "Message of Derived"
}

fun main() {
    val b = BaseImpl(10)
    val derived = Derived(b)
    derived.print()
//    println(derived.message)
}