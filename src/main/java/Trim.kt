fun main() {



    val t = "+7 799 767 67 67"
    println(t.trim(' '))

    val case1 = "BIN123456789012 Company"
    val case1Wrong = "BIN1234567890120 Company"

    val case2 = "VIN123456FJ32/S"
    val case2Wrong = "VIN125/S"

    val case3 = "BIN123456839932 FR425 VINFАУF5/S"
    val case3Wrong = "BIN123456839932 FR425 VINF.F5/S"

    val case4 = "BIN123456839932 FR425 Без VIN-кода"
    val case4Wrong = "BIN123456839932  Без VIN-кода"
}