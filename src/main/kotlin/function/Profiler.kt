package function

import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis

fun main() {

    /**
     * Для тех, кому важна скорость выполнения, Kotlin предлагает полезные функции
     * для профилирования производительности кода: [measureNanoTime] и [measureTimeMillis].
     * Обе функции принимают лямбду как аргумент и измеряют скорость выполнения кода внутри лямбды.
     * [measureNanoTime] возвращает время в наносекундах, а [measureTimeMillis] возвращает время в миллисекундах.
     *
     *
     *
     *
     */
    val nano = measureNanoTime {
        println("some big operation")
    }

    val millis = measureTimeMillis {
        println("some big operation")
    }


}