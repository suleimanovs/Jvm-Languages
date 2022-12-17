package variable

fun main() {

    /**
     * ошибка времени выполнения — это ошибка, которая возникает после компиляции, когда программа уже запущена,
     * потому что компилятор не смог ее обнаружить. Например, так как в Java отсутствует разграничение между
     * типами, поддерживающими и не поддерживающими null, компилятор Java не сможет обнаружить проблему, связанную с
     * присваиванием переменной значения null. Код будет успешно скомпилирован в Java, но во время выполнения вызовет сбой.
     */

    var nullableString: String? = null
    var nonnullString: String = "String"

    nullableString = "Nonnul" // она все равно является nullable
    //  nonnullString = null // error

    nullableString?.length // если переменная не содержит null, то вызови поле length
    nullableString!!.length // уверен что переменная не содержит null, вызови поле length
    nullableString?.length ?: 0 // если переменная не содержит null, то вызови поле length, если все же null, верни 0


}