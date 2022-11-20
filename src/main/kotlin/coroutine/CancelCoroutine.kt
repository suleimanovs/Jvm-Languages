package coroutine

import kotlinx.coroutines.*

/**
 * Created by osmanboy on 3/8/2022
 *
 * При работе приложения может сложиться необходимость отменить выполнение корутины. Например,
 * в мобильном приложении запущена корутина для загрузки данных с некоторого интернет-ресуса,
 * но пользователь решил перейти к другой странице приложения, и ему больше не нужны эти данные.
 * В этом случае чтобы зря не тратить ресурсу системы, мы можем предусмотреть отмену выполнения корутины.
 */
fun cancelCoroutine() = runBlocking {
    coroutineScope {

        val downloader: Job = launch {
            println("Начинаем загрузку файлов")
            for (i in 1..5) {
                println("Загружен файл $i")
                delay(500L)
            }
        }
        delay(800L)     // установим задержку, чтобы несколько файлов загрузились
        println("Надоело ждать, пока все файлы загрузятся. Прерву-ка я загрузку...")
        downloader.cancel()    // отменяем корутину- тоже самое делает метод cancelAndJoin():
        downloader.join()      // ожидаем завершения корутины
        println("Работа программы завершена")
    }
}

fun catchCoroutineException(){
    runBlocking {
        coroutineScope{

            val downloader: Job = launch{
                try {
                    println("Начинаем загрузку файлов")
                    for(i in 1..5){
                        println("Загружен файл $i")
                        delay(500L)
                    }
                }
                catch (e: CancellationException ){
                    println("Загрузка файлов прервана")
                }
                finally{
                    println("Загрузка завершена")
                }
            }
            delay(800L)
            println("Надоело ждать. Прерву-ка я загрузку...")
            downloader.cancelAndJoin()    // отменяем корутину и ожидаем ее завершения
            println("Работа программы завершена")
        }
    }
}

fun main() {
    cancelCoroutine()
    catchCoroutineException()
}