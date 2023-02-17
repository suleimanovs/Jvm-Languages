package variable

import java.math.BigInteger

tailrec fun fibonacci(n: Int, a: BigInteger, b: BigInteger): BigInteger {
    return if (n == 0) b
    else fibonacci(n - 1, a.add(b), a)
}

fun main() {
    val number = fibonacci(10000, BigInteger.ZERO, BigInteger.ZERO)
    println(number.toString())
}