package coroutine

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

/**
 * Created by osmanboy on 3/8/2022
 */

/**
 * Когда функция launch вызывается без параметров, она перенимает контекст, в котором она создается и запускается.
 */
suspend fun main() = coroutineScope {

    launch {
        println("Корутина выполняется на потоке: ${Thread.currentThread().name}")//main
    }

    println("Функция main выполняется на потоке: ${Thread.currentThread().name}")
    createOwnCoroutineContext()
}

/**
 * Рассмотрим доступные типы диспетчеров:
 * Dispatchers.Default: применяется по умолчанию, если тип диспетчера не указан явным образом.
 * Этот тип использует общий пул разделяемых фоновых потоков и подходит для вычислений,
 * которые не работают с операциями ввода-вывода (операциями с файлами, базами данных, сетью)
 * и которые требуют интенсивного потребления ресурсов центрального процессора.
 *
 * Dispatchers.IO: использует общий пул потоков, создаваемых по мере необходимости, и предназначен
 * для выполнения операций ввода-вывода (например, операции с файлами или сетевыми запросами).
 *
 * Dispatchers.Main: применяется в графических приложениях, например, в приложениях Android или JavaFX.
 *
 * Dispatchers.Unconfined: корутина не закреплена четко за определенным потоком или пулом потоков.
 * Она запускается в текущем потоке до первой приостановки. После возобновления работы корутина
 * продолжает работу в одном из потоков, который сторого не фиксирован.
 * Разработчики языка Kotlin в обычной ситуации не рекомендуют использовать данный тип.
 *
 * newSingleThreadContext и newFixedThreadPoolContext: позволяют вручную задать поток/пул для выполнения корутины
 */


fun createOwnCoroutineContext() = runBlocking {
    coroutineScope {

        launch(newSingleThreadContext("Custom Thread")) {
            println("Поток корутины: ${Thread.currentThread().name}")
        }

        println("Поток функции main: ${Thread.currentThread().name}")
    }
}