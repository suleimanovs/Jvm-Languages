package project.course.function

/**
 * ключевое слово [infix] доступно для функций класса, и функций рассширения с одним параметром
 */
infix fun String?.getOrDefault(defaultValue: String) = this?:defaultValue


fun main() {
    val str = "String"

    /**
     * и блогодарья infix мы можем вызвать функцию так,
     * вызов этой функций аналог - str.getOrDefault("Default")
     */
    str getOrDefault "Default"
}