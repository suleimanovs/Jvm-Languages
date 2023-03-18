package course

import `class`.Programmer
import `class`.Worker

/**
 * Created by user on 20:06
 */
fun main() {

    /**
     * Что если нам надо будет вызвать какую то функцию из класса только одинь раз,
     * для этого нам нужно создать отдельную переменную, экземпляр
     */
    val programmer = Programmer("Boy" , 34 , "Ruby")
    worker(programmer)


    /**
     * Решение - использовать object(anonym class)
     */
    worker(object : Worker("Osman",19) {
        override fun work() {
            println("$name is working")
        }
    })

}

fun worker(worker: Worker) {
    worker.work()
}