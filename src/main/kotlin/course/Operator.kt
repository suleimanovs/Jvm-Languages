package project.course


fun main() {
    val calculate = Calculate()

    // with operator invoke
    calculate(1,2,4,5,6,7,8,9)
    println(calculate.contains(42))

    // without operator invoke
    calculate.sum(1,3,4,5,7,8)
}

class Calculate {

    /**
     * Если класс отвечает за что-то одно , то можно вызвать оператор invoke,
     * и передать нужные параметры именно туда
     */
    var sum= 0

    operator fun invoke(vararg value : Int): Int{
        for(i in value){
            sum+=i
        }
        return sum
    }

    fun sum(vararg value : Int): Int{
        var sum= 0
        for(i in value){
            sum+=i
        }
        return sum
    }

    operator fun contains(param : Int): Boolean{
       return param == sum
    }
}