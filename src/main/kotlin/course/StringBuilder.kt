package course

import java.lang.StringBuilder

fun <T> Collection<T>.converter(separator: String, firstPrefix:String, lastPrefix: String) : String{

    /**Class StringBuilder используется , когда возникает необходимость сделать много изменнений в строке символов.
     * Вотличие от строк , обьекты типа StringBuilder могут быть изменены снова и снова */
    val result = StringBuilder(firstPrefix)

    for ((index,element) in this.withIndex()){
        if(index>0)result.append(separator)
    }
    /** append добавляет новые строки и символы, под капотом на самом деле тут дело имеется с char(символ)*/
    result.append(lastPrefix)
    return result.toString()

}

fun main() {

    val list = listOf(1,2,3,5,6,6,7,7)
    println(list.converter(",","{ "," }"))
}