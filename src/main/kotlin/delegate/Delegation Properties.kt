package delegate.delegate_property

import kotlin.reflect.KProperty

/**
 * Created by osmanboy on 2/12/2022
 */
fun main() {
    val user = User()
    println(user.name)
    user.name = "Osman"
    println(user.name)
}


class User {
    /**
     * при вызове [getter] для свойства [name] будет вызван метод [Delegate.getValue]
     * при вызове [setter] для свойства [name] будет вызван метод [Delegate.setValue]
     */
    var name: String by Delegate()

//    var age: Int by delegateParametrized()
}

/**
 * Сгенерированный класс будет следующим
 * class User {
 *     private val nameDelegate = Delegate()
 *     var name: String
 *         set(value) = nameDelegate.setValue(this, ::name, value)
 *         get() = nameDelegate.getValue(this, ::name)
 * }
 */

class Delegate {

    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name}' in $thisRef.")
    }

}

class DelegateParametrized<T> {

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return thisRef as T
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        println("$value has been assigned to '${property.name}' in $thisRef.")
    }

}

fun <T> delegateParametrized() = DelegateParametrized<T>()