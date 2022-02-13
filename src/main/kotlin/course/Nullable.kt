package project.course

fun main() {
    val str1: String? = null
    val str2: String? = "null"
    val str3: String? = ""


   /**
    *  если не взять все переменные в скобки то сложить их
    *  было бы не возможно, оператор Элвис не сработал бы
    * */
    val result = (str1?.length ?: 0) + (str2?.length ?: 0) + (str3?.length ?: 0)
    print(result)


}