package exception

fun main() {

    /**
     * В котлин нет CompileTimeError/Checked Exception(проверяемые исключения). и нет синтаксиса для try with resources
     * В Kotlin все исключения непроверяемые. Это значит, что компилятор Kotlin не заставляет запихивать весь код,
     * который может вызвать исключения, в оператор try/catch.
     *
     * Ключевое слово try в языке Kotlin наряду с if и when является выражением, значение которого можно присвоить
     * переменной. В отличие от if, тело выражения всегда нужно заключать в фигурные скобки.
     * try является выражением, что означает, что оно может иметь возвращаемое значение:
     */
    val x = try {
        `испытать судьбу`()
        11
    } catch (e: Exception) {
        e.printStackTrace()
        22
    } finally {
        println("end")
    }

    val str = listOf<String?>("one", null).random()

    /**
     * throw— выражение в Kotlin, поэтому его можно использовать, например, как часть выражения Элвиса:
     */
    val s = str ?: throw IllegalArgumentException(" required")


    /**
     * Возбуждает IllegalStateException, если аргумент null. В противном случае возвращает полученное значениe
     */
    checkNotNull(str)

    /**
     * Возбуждает IllegalArgumentException, если условие не выполняется
     */
    require(str != null, { "must been not null" })


    /**
     * Возбуждает IllegalArgumentException, если аргумент null. В противном случае возвращает полученное значение
     */
    requireNotNull(str, { "must been not null" })

    /**
     * Возбуждает IllegalArgumentException с указанным сообщением, если аргумент null.
     * В противном случае возвращает полученное значение
     */
    error("error")





}

fun `испытать судьбу`() {
    println("some")
    throw IllegalStateException("")
}