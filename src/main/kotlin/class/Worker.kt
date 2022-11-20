package `class`

abstract class Worker(val name:String, age:Int){

    /**
     * Если и функцию отметить как abstract, то его переопределение в классах наследниках обьязательно
     */
    open fun work(){
        println("I'm working")
    }

}