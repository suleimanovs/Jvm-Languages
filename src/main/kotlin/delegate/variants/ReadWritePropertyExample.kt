package delegate.variants

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * [ReadWriteProperty] - явялется интерфейсом делегатом, который может быть использован как для
 * val переменных, так и для var. Поскольку у него есть [ReadWriteProperty.setValue] и [ReadWriteProperty.getValue]
 * Сам интерфейс не является чем-то магическим, Можно создать делегат для чтения и записи и без этого интерфейса.
 */

class TrimDelegate : ReadWriteProperty<Any?, String> {

    private var trimmedValue: String = ""

    override fun getValue(thisRef: Any?, property: KProperty<*>) = trimmedValue


    override fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        trimmedValue = value.trimStart()
    }
}

fun main() {

    /**
     * Поскольку [TrimDelegate] является делегатом [ReadWriteProperty],
     * то мы можем использовать его как для var так и для val
     */
    var name by TrimDelegate()
    println(name)
    name = "                  Osman"
    println(name)
    println(name)

}