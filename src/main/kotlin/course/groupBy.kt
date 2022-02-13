package course

fun main() {

    val ints=listOf(1,2,3,4,5)

    val pizzas=listOf(Pizza("Sunny Chicken",4.5,4), Pizza("Goat and Nut",4.0,1),
    Pizza("Tropical",3.0,2),Pizza("The Garden",3.5,3))
    //groupBy сгруппирует
    val qr= pizzas.groupBy { it.quantity}
    for(qr in qr){println(qr)}




//    var mapList = mapOf(
//            "Январь" to listOf(100, 100, 100, 100),
//            "Февраль" to listOf(200,200,-190,200),
//            "Март" to listOf(300,180,300,100),
//            "Апрель" to listOf(250,-250,100,300),
//            "May" to listOf(200,100,400,300),
//            "June" to listOf(200,100,300,300)
//    )
//    printInfo(mapList)

}
data class Pizza(val name:String, val pricePerSlice:Double, val quantity: Int)

//fun printInfo(data:Map<String,List<Int>>){
//
//    val validData=data.filter { it.value.all{it>=0} }
//
//    var averageWeek=validData.flatMap { it.value }.average()
//
//    val listOfSum=validData.map { it.value.sum() }
//
//    val inValidData=data.filterNot { it.value.all{it>=0} }.keys
//
//    val maxMonth=validData.filter{it.value.sum()==listOfSum.max()}.keys
//    val minMonth=validData.filter{it.value.sum()==listOfSum.min()}.keys
//
//
//    println("Средняя выручка в месяц: ${listOfSum.average()}")
//    println("Максимальная выручка в меcяц:${listOfSum.max()}")
//    println("Была в месяцах $maxMonth")
//    println("Ошибки произошли в следующих месяцах: $inValidData")
//    println("Минимальная выручка в меcяц:${listOfSum.min()}")
//    println("Была в месяцах $minMonth")
//    println("Средняя выручка в неделью: $averageWeek")
//    println("")



//    }













