package delegate.variants

import kotlin.properties.ReadOnlyProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * [ReadOnlyProperty] - явялется интерфейсом делегатом, который может быть использован только для val переменных,
 * Поскольку у него есть только [ReadOnlyProperty.getValue]
 * Сам интерфейс не является чем-то магическим, Можно создать делегат только для чтения без этого интерфейса.
 */

class StringLazy(private var initializer: (() -> String)?) : ReadOnlyProperty<Any?, String> {

    internal object UNINITIALIZED_VALUE


    private var _value: Any? = UNINITIALIZED_VALUE

    val value: String
        get() {
            if (_value === UNINITIALIZED_VALUE) {
                _value = initializer!!()
                initializer = null
            }
            return _value as String
        }

    override operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return value
    }

}


fun main() {


    /**
     * Поскольку [StringLazy] является делегатом [ReadOnlyProperty],
     * то мы можем использовать его только для val, так как у него нет setValue()
     */
    val name: String by StringLazy {
        println("initial")
        "Sara"
        "Osman"
    }

    println(name)
    println(name)
    println(name)

}