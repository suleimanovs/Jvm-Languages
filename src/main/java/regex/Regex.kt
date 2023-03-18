package regex

import regex.PurposeRegex.*
fun main(args: Array<String>) {

    val case1 = "BIN123456789012 Company"
    val case1Wrong = "BIN1234567890120 Company"

    val case2 = "VIN123456FJ32/A"
    val case2Wrong = "VIN1FRF5/A"

    val case3 = "BIN123456839932 FR425 VINEEE34RHFUFHO2/S"
    val case3Wrong = "BIN123456839932 FR425 VINFАУFJD5F5/S"

    val case4 = "BIN123456839932 FR425 Без VIN-кода"
    val case4Wrong = "BIN123456839932  Без VIN-кода"

    println(case1.handlePurposeType())
    println(case1Wrong.handlePurposeType())

    println(case2.handlePurposeType())
    println(case2Wrong.handlePurposeType())

    println(case3.handlePurposeType())
    println(case3Wrong.handlePurposeType())

    println(case4.handlePurposeType())
    println(case4Wrong.handlePurposeType())


}

enum class PurposeRegex(val regex: Regex) {
    PURPOSE_MAIN(Regex("""$BIN\d{12}\s\w+\s$VIN[A-Z-0-9-]{3,}/[PVBS]""")),
    PURPOSE_ONLY_VIN(Regex("""$VIN[A-Z-0-9-]{3,}/[PVBS]""")),
    PURPOSE_ONLY_BIN(Regex("""$BIN\d{12}\s\w+""")),
    PURPOSE_WITHOUT_VIN(Regex("""$BIN\d{12}\s\w+\s$WITHOUT_VIN"""))
}


private fun String.handlePurposeType() = matches(
    when {
        contains(WITHOUT_VIN, true) -> PURPOSE_WITHOUT_VIN
        contains(BIN, true) && contains(VIN, true) -> PURPOSE_MAIN
        contains(BIN, true) && contains(VIN, true).not() -> PURPOSE_ONLY_BIN
        contains(VIN, true) && contains(BIN, true).not() -> PURPOSE_ONLY_VIN
        else -> PURPOSE_MAIN
    }.apply {
        println("handlePurposeType: $this")
        println("handlePurposeType: $regex")
    }
        .regex
)

private const val BIN = "BIN"
private const val VIN = "VIN"
const val WITHOUT_VIN = "Без VIN-кода"