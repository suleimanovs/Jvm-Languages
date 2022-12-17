package dsl

fun buildString(builderAction: StringBuilder.() -> Unit) = StringBuilder().apply(builderAction).toString()


fun main() {
    buildString {
        append("Hello")
        append("How are you")
    }

}