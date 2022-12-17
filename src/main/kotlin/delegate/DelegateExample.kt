package delegate

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by osmanboy on 2/4/2022
 */

class TrimDelegate : ReadWriteProperty<Any?, String> {

    private var trimmedValue: String = ""

    override fun getValue(thisRef: Any?, property: KProperty<*>) = trimmedValue


    override fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        trimmedValue = value.trimStart()
    }
}

fun main() {

    var name by TrimDelegate()
    println(name)
    name = "                  Osman"
    println(name)

}