package project.standart_functions


fun main() {


val foldedValue=listOf(1,2,3,4).fold(0){accumulator, number->
    /**
     *  в начале в accumulator содержиться начальное значение, которое мы передали в конструктор
     *  то есть равен нуью fold(initial: 0), а в number содержиться первое число из listOf потом
     *  эти две начальные значения сложиться, то есть в нашем случае 0+1= 0, результат храниться
     *  в accumulator и точно так же прдолжается цикл, второй цикл будет уже accumulator: 1 + number: number
     */

     accumulator   +    number}
    println(foldedValue)//10

    /** есть еще функция reduce она работает так же как и
     * fold, только начальное значение указать не надо
     */
}

