@file:JvmName("DeprecatedEx")

package annotation.standart_annotation

/**
 * Рассмотрим более интересный пример - аннотацию @Deprecated.
 * В Kotlin она имеет то же значение, что и в Java, но Kotlin добавляет в неё параметр replaceWith,
 * в котором можно указать шаблон замены для поддержки постепенного перехода на новую версию API.
 * Следующий пример показывает, как передать аргументы в аннотацию (сообщение об использовании устаревшего API и шаблон замены):
 *
 * С таким объявлением, если кто-либо использует функцию remove, IntelliJ IDEA не только покажет,
 * какая функция должна использоваться взамен (в данном случае removeAt),
 * но также предложит возможность выполнить замену автоматически
 */
@Deprecated(message ="Use removeAt(index) instead", replaceWith = ReplaceWith("removeAt(index)"))
fun remove(index:Int) {

}

fun removeAt(index:Int) {

}

fun main(args: Array<String>) {
    remove(12)
}