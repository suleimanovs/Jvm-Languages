package course

fun main() {
    var array=(1..1000).toList()


    //.map{number:String->"Employer$number"}  сокращено- сейчас оно до 1000
    var arrayCopy=array.map{"Cотрудник N=$it"}



//  берет первые 30 чисел из беконечной последовательности
    var take=arrayCopy.take(100)


//  берет первые 30 чисел из беконечной последовательности
    var takeLast=arrayCopy.takeLast(30)


//  берет все числа которые следует после 30, первые 30 выбрасывает
    var drop=arrayCopy.drop(30)


//  выбрасывает все 30 элементов с конца, выводит начиная от 0..970
    var dropLast=arrayCopy.dropLast(30)

    for(i in take){
        println(i)
    }







}