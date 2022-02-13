package standart_functions

fun main() {

    val mapList= mapOf(
            "Osman" to listOf(10,10,10,10),
            "Random" to listOf(5,-5,5),
            "Under" to listOf(10,10,10))

    // *ALL* принимает функцию, и возвращает true / false, если хоть один элемент дает false, то и весь list дает false
    // *FLATMAP* перебирает каждый list, возвращая list<Int>, в отличие от map <List<List<Int>>
    // *AVERAGE* возвращает среднее значние
    /* ANY* возвращает true, если хотя бы один элемент дасть true, но еслидобавить filterNot вместо filter,
    то все будет работать корректно*/
    val all=mapList.filter { it.value.all{ it>=0} }.flatMap { it.value }.average().toInt()
    println(all)
}