package reflection

import annotation.standart_annotation.test
import variable.sum
import kotlin.math.floor
import kotlin.reflect.*

/**
 * Механизм рефлексии позволяет обращаться к свойствам и методам объектов динамически, во время выполнения,
 * не зная заранее, каковы они. Обычно обращение к методу или свойству в исходном коде программы оформляется как ссылка
 * на конкретное объявление, которую компилятор обрабатывает статически и проверяет существование объявления.
 * Но иногда требуется написать код, который смог бы работать с объектами любых типов или с объектами,
 * имена свойств и методов которых становятся известны только во время выполнения.
 */

class Car(val name: String) {
    var model: String = "unknown"
    fun drive() {

    }
}

/**
 * [KCallable] - это супер интерфейс для функций и свойств. Он объявляет метод [KCallable.call],
 * с помощью которого можно вызвать соответствующую функцию или метод чтения свойства
 *
 * Механизм рефлексии можно использовать только для обращения к свойствам, объявленным на верхнем уровне или в классе,
 * но не к локальным переменным внутри функций.
 */
var counter = 14
fun foo(int: Int) = println(int)
fun sum(x: Int, y: Int) = x + y

fun testKCallable() {


    /**
     * В данном случае нужно передать единственный аргумент,
     * Попытка вызвать функцию с неправильным количеством аргументов - например,
     * вообще без аргументов: [kFunction.саll()],- приведет к появлению исключения lllegalArgumentException
     */
    val kFunction = ::foo
    kFunction.call(12)

    val kFunction1: KFunction2<Int, Int, Int> = ::sum
    println(kFunction1.invoke(12, 12))

    val kProperty = ::counter
    println(kProperty.call()) //get
    kProperty.setter.call(34)
    println(kProperty.get()) //get

}

/**
 * [KClass] - это Kotlin-вepcия типа [java.lang.Class] в Java. Он используется для хранения ссылок на классы Kotlin.
 * Типовой параметр в [KClass] определяет, на какие классы Kotlin может ссылаться данная ссылка.
 * Получить экземпляр [KClass] можно с помощью ClassName::class, если класс заранее известен, или obj.javaClass.kotlin,
 * чтобы получить класс из экземпляра объекта
 */

fun main() {

    /**
     * Поскольку все объявления могут аннотироваться, интерфейсы, представляющие объявления во время выполнения,
     * такие как [KClass], [KFunction] и [KParameter], наследуют [KAnnotatedElement].
     * [KClass] используется для представления элементов двух видов: классов и объектов.
     * [KProperty] может представлять любые свойства,
     * а его подкласс [KMutableProperty] -только изменяемые свойства, объявленные с использованием var.
     * Для работы с методами доступа к свойствам как с функциями можно использовать
     * специальные интерфейсы [KProperty.Getter] и [KMutableProperty.Setter],
     * объявленные в [KProperty] и [KMutableProperty], - например, если понадобится извлечь их аннотации.
     */
    val kClass = Car::class

    kClass.members.forEach {
        val info =
            """name: ${it.name} returnType: ${it.returnType} isOpen: ${it.isOpen} isAbstract: ${it.isAbstract} """ + """"visibility: ${it.visibility} """

        println(info)
    }

    testKCallable()


    val o = Outer()
    val boundInnerCtor = o::Inner
    val inner = boundInnerCtor() // o.Inner()
}

/**
 * Привязанную вызываемую ссылку на конструктор внутреннего класса можно получить, предоставив экземпляр внешнего класса:
 */

class Outer {
    inner class Inner
}






