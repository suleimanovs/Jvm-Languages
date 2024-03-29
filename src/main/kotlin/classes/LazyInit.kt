package classes

import kotlin.random.Random

class LazyInit {

    /**
     * Можно задерживать инициализацию переменной до первого обращения к ней. Эта идея известна как отложенная инициализация,
     * и, несмотря на свое название, она может сделать код более эффективным.
     */
    val value by lazy {
        Random(100).nextInt()
    }

}