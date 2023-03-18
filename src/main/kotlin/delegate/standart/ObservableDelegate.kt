package delegate.standart

import kotlin.properties.Delegates

/**
 * [Delegates.observable] принимает два аргумента: начальное значение и обработчик для модификаций.
 * Обработчик вызывается при каждом назначении свойству (после выполнения назначения).
 * Он имеет три параметра: свойство, которому присваивается, старое значение и новое значение:
 */


class User {

    var name: String by Delegates.observable("<no name>") { property, oldValue, newValue ->
        println("value changed from $oldValue to $newValue")
    }

}

fun main() {
    val user = User()
    user.name = "first"
    user.name = "second"
}