package project.standart_functions

import kotlin.random.Random

fun main() {
    //если не преоброзовать с помощью toList(), то это будет просто диапозоном, от 0..100
    val numbers= (0..100).toList()


    //  .map{number:Int->number*2} - соответственно можно вот так сократить:
    val doubledNumbers= numbers.map{it*2}




    //  .map{name:Int->"Employers$name"} - соответственно можно вот так сократить:
    val employers= numbers.map{"Employers N=$it"}

    
    //генерация случайного числа
    var ss= Random.nextInt(0,12 )

    val numbersX= mutableListOf<Int>(7,4,8,4,3,22,18,11,24,25,16,15)
//    val numbersX= listOf<List<Int>>(listOf(1,3,2,7,4,8,4,3,22,18),listOf(7,4,8,4,3,22,18,2,3,1),listOf(7,4,8,4,3,22,18))

    val new=  mapOf<Int,Int>(1 to 3, 4 to 6, 7 to 5)
    println(numbersX.map { it })

    val primers=numbersX.filter { number-> (2 until number).map { number % it }.none { it==0} }
    println(primers)



}