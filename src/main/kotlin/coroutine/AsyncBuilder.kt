package coroutine

import kotlinx.coroutines.*

/**
 * Created by osmanboy on 3/8/2022
 */
/**
 * Наряду с launch в пакете kotlinx.coroutines есть еще один построитель корутин-функция async.
 * Эта функция применяется, когда надо получить из корутины некоторый результат.
 * async запускает отдельную корутину, которая выполняется параллельно с остальными корутинами.
 */
fun returnSomethingFromCoroutine() {
    /**
     * Кроме того, async-корутина возвращает объект Deferred, который ожидает получения результата
     * корутины. (Интерфейс Deferred унаследован от интерфейса Job, поэтому для него также доступны весь
     * функционал, определенный для интефейса Job)
     * Для получения результата из объекта Deferred применяется функция [await].
     */
    runBlocking {
        val deferred1: Deferred<Int> = this.async(start = CoroutineStart.LAZY) {
            delay(2000)
            500
        }

        val deferred2: Deferred<Int> = this.async(start = CoroutineStart.LAZY) {
            delay(2000)
            700
        }
        deferred1.start()
        deferred2.start() //метод await сделало тоже самое, запустив на выполнение и ожидать результат.
        print(deferred1.await() + deferred2.await())
    }
}