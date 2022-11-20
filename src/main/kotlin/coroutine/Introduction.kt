package coroutine

import kotlinx.coroutines.*

/**
 * Created by osmanboy on 3/8/2022
 */

/**
 * Что такое корутины - это соопрограммы, средство которая позволяет писать асинхронный(разновременный)
 * код, при этом в стиле синхронного(последовательного) кода. Корутины что-то вроде легких потоков.
 * Но более дешевые и легковесные. Все сопрограммы работают на пуле(Что-то наподобие Executor) нитей.
 * Асинхронный код (из асинхронного программирования) — это код, который выполняется параллельно другим.
 * В синхронном программировании код выполняется строка за строкой
 */


fun startCoroutine1() {
    GlobalScope.launch { // запускает корутину на выполнение
        delay(2000) // остонавливает выполнение кода на 2 секунды
        print("World\n")
    }
    println("Hello ")
    Thread.sleep(3000) // заддерживает главный поток, иначе корутина не успеет выполниться
}

fun startCoroutine2() = runBlocking { // тоже приостанавливает главный поток
    GlobalScope.launch {
        delay(2000)
        print("World")
    }
    println("Hello ")
}


fun startCoroutineCancel() = runBlocking {
    val job = GlobalScope.launch {
        delay(5000)
        print("World")
    }
    println("Hello ")
    delay(2500)
    job.cancel() //отмена корутины cancelAndJoin() делает тоже самое
    job.join()
}




fun startLazyCoroutine()= runBlocking{
    // корутина создана, но не запущена
    val job = launch(start = CoroutineStart.LAZY) {
        delay(200L)
        println("Coroutine has started")
    }

    delay(1000L)
    job.start() // запускаем корутину
    println("Other actions in main method")
}

fun main() {
    startLazyCoroutine()
//    startCoroutineCancel()
//    startCoroutine2()
//    startCoroutine1()
}