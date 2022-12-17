package variable


fun main() {

    val string = "String"

    val charSequence = string as CharSequence // если нет никаих отношений is?, то выбросится ClassCastException

    println(charSequence)

    val charSequenceOrNull = string as? CharSequence // или вернется charSequence или null

}