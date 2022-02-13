package course

import kotlin.system.measureNanoTime

fun main() {


    val listInNanosForEach = measureNanoTime {
        (0..10000).forEach {
            it
        }
    }
    val listInNanonFor= measureNanoTime {
        for(i in 0..10000){
            i
        }
    }
    println("forEach $listInNanosForEach")
    println("for: $listInNanonFor")


}