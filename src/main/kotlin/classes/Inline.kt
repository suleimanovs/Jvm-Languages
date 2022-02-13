package classes

import java.security.Security

/**
 * Created by IntelliJ IDEA: osmanboy on 1/24/2022
 */
@JvmInline
value class Password(val security: String)

fun main() {


    val securityPassword = Password("1hronos_55")
    println(securityPassword)
}