package project.course.function

fun main() {

    /**
     * Здесь описаны такие функций как filter и map, start with , end with ..
     * */

    val listOfNumbers = mutableListOf(2 , 5 , 6 , 7 , 9 , 8 , 6 , 4 , 3 , 21 , 124 , 13)

    /**
     * Метод filter всегда возвращает boolean,(по умолчанию - true)
     * и если все соответсвует критериям,  берет именно этот
     * Если вызываемый метод(filter, как и любая другая функция высшего порядка)
     * является последним в списке вызовов, то круглые скобки можно опустить
     * */
    val listOfEventNumbers = listOfNumbers.filter({ it % 2 == 0 })


    val listOfName = arrayListOf<String>("Astra" , "Alisa" , "Osman" , "Sara" , "Amar")

    /**
     * @startWith - берет проверяет есть ли в списке элменты с указанным префиксом
     * */
    val listOfEventName = listOfName.filter { it.startsWith("A") }



    /**
     * @map - получает массив и возвращает массив, но можно преобразовав в любой другой тип
     * */
    val listForMap = arrayListOf(2 , 4 , 3 , 5 , 6 , 7 , 8 , 9)
    val listForMapNew: List<String> = listForMap.map { "${it * 2}" }


    /**
     * @Zip - обьяденяте два коллекций и возвращает новый List,состоящий из Pair<T,T>
     * и обращатьс к ним можно по first, second
     */

    val name = arrayListOf("Osman" , "Sara" , " Eric" , "Kamila" , "Giorgi")
    val phone = arrayListOf("+7-911-000-00-00" , "+7-911-000-00-00" , "+7-911-000-00-00" , "+7-911-000-00-00" , "+7-911-000-00-00")


    val users = name.zip(phone)


    /**
     * @flatMap - принимает коллекцию содержащей коллекцию, и возвращает обьяденную коллекцию
     */
    val listOfThings = listOf(listOf("red apple" , "green apple" , "blue  apple") , listOf("red fish" , "green fish" , "blue fish"))
    val listOfNumber = listOf(listOf(1 , 2 , 3 , 4 , 5 , 6) , listOf(7 , 8 , 9 , 10))

    listOfNumber.flatMap { it } // listOf(1,2,3,4,5,6,7,8,9,10)
    listOfThings.flatMap { it.filter { it.contains("apple") } }


    /**
     * @none - если условие внутри блока окажется верным то вернет лож,
     * а если условие внутри блока окажеться ложным то вернет истину
     */

    val numbers = listOf(7 , 4 , 8 , 4 , 3 , 22 , 18 , 11)
    val primers = numbers.filter { number ->
        (2 until number).map { number % it }.none { it == 0 } //если условие равно true, то вернет лож
    }


    /**
     * @generateSequence - функций итератор ,  принимает насальное значение, которая будет точкой
     * старта для последовательностей. и при обращения к ней, она запустить бесконечную
     * последовательность, но тут она будет идти до тех пор пока функция не получит нужное
     * количестов  
     */

    val oneThousand =  generateSequence(3,{it +1}).filter { it.isPrime() }.take(1000)


}