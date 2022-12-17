package function

/**
 * Ключевое слово [infix] доступно для функций класса, и функций расширения с одним параметром
 * инфиксная нотация поможет упростить вызовы функций с одним аргументом;
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