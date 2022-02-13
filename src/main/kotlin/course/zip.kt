package course

fun main() {

    var names= mutableListOf<String>()
    var phones= mutableListOf<Long>()
    for(i in 0..1000){
        names.add("$i")
        phones.add(77_000_000_000+(Math.random()*1_000_000_000).toLong()) }


    var users=names.zip(phones)
//    for((names,phones) in users){
//        println("Name=$names phone+$phones")
//    }

    var name= mutableListOf<String>("Osman","Farhad","Salim","Ivan","Sara","Roma")
    var fio= mutableListOf<String>("Suleimanov","Kopanov","Durov","Zhuzhoev","Barhudar","Salarov")


//    zip обьяденяет два списка
    var people=name.shuffled().zip(fio.shuffled())
    for((name,fio) in people){
        println("$name $fio")

    }



    val employees = listOf("Denny","Claudette","Peter")
    val shirtSize = listOf("large","x-large","medium")
    /**
     * здесь функция zip обьяденяет два листа,
     * а toMap() преобразует их в словарь(Pair), где
     * первый лист ключь, а второй значение
     **/

    val employeesSize=employees.zip(shirtSize).toMap()
}