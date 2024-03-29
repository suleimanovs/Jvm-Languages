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

        val downloader: Job = launch {
            println("Начинаем загрузку файлов")
            for (i in 1..5) {
                println("Загружен файл $i")
                /**
                 * [delay] проверяет, если корутина отменена, то есть isActive = false, то он остановит корутину,
                 * выбрасив ошибку [CancellationException].
                 * Что бы проверить отменена ли корутина или нет, нужно вызвать поле [isActive], если оно равно false
                 * то выбросить [CancellationException].
                 * метод [ensureActive] может такую проверку сделать и остановить корутину
                 */
                delay(500L)

            }
        }
        downloader.invokeOnCompletion {
            println("was canceled" + it?.message.toString())
        }
        delay(800L)     // установим задержку, чтобы несколько файлов загрузились
        println("Надоело ждать, пока все файлы загрузятся. Прерву-ка я загрузку...")
        /**
         * Что бы дождаться окончания Job, нужно вызвать метод [Job.join]
         * Что бы установить значение флага [isActive] в false, нужно вызвать метод [Job.cancel]
         * Чтобы остановить поток, и дождаться этого, нужно вызвать метод [Job.cancelAndJoin]
         */
        downloader.cancel() // данный вызов аналогичен
        downloader.join() // вызову cancelAndJoin
        println("Работа программы завершена")

}


fun main() {
    cancelCoroutine()
}