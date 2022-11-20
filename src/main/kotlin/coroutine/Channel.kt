package coroutine

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Created by osmanboy on 3/8/2022
 */

suspend fun main() = coroutineScope{

    val channel = Channel<Int>()
    launch {
        for (n in 1..5) {
            delay(1000)
            // отправляем данные через канал
            channel.send(n)
        }
    }

    // получаем данные из канала
    repeat(5) {
        val number = channel.receive()
        println(number)
    }
    println("End")
}