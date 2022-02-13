package course

fun main() {

    /** в Map в отлчий от значений все ключи уникальные, и если в map встречаться два одинаковых
     * ключей, то добавленная ранее удалиться и заменится боле позднее добавленной
     */
    val map = mutableMapOf("Osman" to 2)
    map.containsKey("Osman") // проверка на существование
    map.containsValue(2)// проверка на существование
    map.get("Osman"); map["Osman"] //получать значение по ключу,обе возвращают null если такого ключа нет
    map.getValue("Osman") //получать значение по ключу,вызывает исключение если такого кдюча нет
    //map.getOrElse("Omar"){"default"}//значения по умолчанию в случае не существующего ключа
    //map.getOrDefault("Omar","default")//значения по умолчанию в случае не существующего ключа
    map.put("Suk",13); map["Sul"]=10 //вставка новой пары
    map.putAll(mapOf("Обама" to 13))// вставка массива в массив
    map.remove("Osman")// deleted
    map.clear() // clear all of keys and values
    map.toSortedMap()     







}

