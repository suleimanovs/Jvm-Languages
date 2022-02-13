package delegate.delegates.kotlin

/**
 * Created by osmanboy on 2/12/2022
 */

fun main() {
    /**
     * Lazy - ленивая инициализация, вся лямбда функция которую мы передали в функцию [lazy] оно будет присвоено
     * переменной только один раз, повторные вызовы бесполезны.
     */
    val car = Car()
    println(car.name) // initial commit /n  BMW
    println(car.name) // BMW
    println(car.age)
    println(car.age)
}

class Car {
    val name by lazy {
        println("initial")
        "BMW"
    }
    val age by ownlazy {
        println("initial")
        20
    }

}

internal object UNINITIALIZED_VALUE

class OwnLazyImpl<out T>(private var initializer: (() -> T)?) : Lazy<T> {
    private var _value: Any? = UNINITIALIZED_VALUE

    override val value: T
        get() {
            if (_value === UNINITIALIZED_VALUE) {
                _value = initializer!!()
                initializer = null
            }
            return _value as T
        }

    override fun isInitialized(): Boolean = _value !== UNINITIALIZED_VALUE

    override fun toString(): String = if (isInitialized()) value.toString() else "Lazy value not initialized yet."

}

fun <T> ownlazy(initializer: (() -> T)?) = OwnLazyImpl<T>(initializer)

