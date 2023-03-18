package delegate.standart

import kotlin.reflect.KProperty

/**
 * Created by osmanboy on 2/12/2022
 */

fun main() {

    /**
     * [lazy] - ленивая инициализация, — функция, которая принимает лямбду и возвращает экземпляр,
     * который может служить делегатом для реализации свойства lazy. Первый вызов выполняет лямбду,
     * переданную и запоминает результат. Последующие вызовы, чтобы просто вернуть запомненный результат.
     * Функция lazy из стандартной библиотеки позволяет просто реализовать отложенную инициализацию свойств.
     *
     * Функция [lazy] только с лямбдой по умолчанию является поток безопасным. Функция Lazy является onlyRead,
     * то есть объявить его можно только для val переменных, это значит что у него есть только [Lazy.getValue] но
     * не setValue
     *
     */
    val car = Car()
    println(car.name) // initial commit /n  BMW
    println(car.name) // BMW

    /**
     * По умолчанию оценка свойств lazy синхронизируется: значение вычисляется только в одном потоке, но все потоки
     * будут видеть одно и то же значение. Если синхронизация делегата инициализации не требуется для одновременного
     * выполнения несколькими потоками, передайте в качестве параметра LazyThreadSafetyMode.PUBLICATION в lazy()
     */
}

class Car {

    //Код в лямбде будет вызван только один раз
    val age by lazy {
        println("initial")
        12
    }

    //Код в лямбде будет вызван только один раз
    val name by ownlazy {
        println("initial")
        "BMW"
    }

}


class OwnLazyImpl<out T>(private var initializer: (() -> T)?) {

    internal object UNINITIALIZED_VALUE


    private var _value: Any? = UNINITIALIZED_VALUE

    val value: T
        get() {
            if (_value === UNINITIALIZED_VALUE) {
                _value = initializer!!()
                initializer = null
            }
            return _value as T
        }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value
    }


}

fun <T> ownlazy(initializer: (() -> T)?) = OwnLazyImpl<T>(initializer)

