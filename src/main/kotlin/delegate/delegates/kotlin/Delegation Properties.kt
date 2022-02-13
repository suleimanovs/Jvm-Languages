package delegate.delegates.kotlin

import kotlin.reflect.KProperty

/**
 * Created by osmanboy on 2/12/2022
 */
fun main() {
    val user = User()
    user.name="Osman"
    println(user.name)
}
class User {
    var name: String by Delegate()

}

class Delegate {

    operator fun getValue(thisRef: Any? , property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any? , property: KProperty<*> , value: String) {
        println("$value has been assigned to '${property.name}' in $thisRef.")
    }
}