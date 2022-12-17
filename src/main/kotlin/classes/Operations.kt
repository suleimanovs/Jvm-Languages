package classes

class Operations(val value: Int) {

    val TAG = 14

    /**
     * Теперь объекты данного класса поддерживают мульти декларацию. То есть мы можем так:
     * val (value,tag) = Operations(12). тогда у value будет зачение 12, а у tag будет 14
     */
    operator fun component1() = value
    operator fun component2() = TAG


    // +
    operator fun plus(other: Operations) = Operations(value + other.value)

    // -
    operator fun minus(other: Operations) = Operations(value - other.value)

    //*/
    operator fun times(other: Operations) = Operations(value * other.value)

    // /
    operator fun div(other: Operations) = Operations(value / other.value)

    // () //можно вызвать класс как функцию
    operator fun invoke(s: String, d: Double) = println("invoke")

    // () // перегруженный invoke
    operator fun invoke(s: String) = println("invoke")

    // [12]
    operator fun get(i: Int) = i * value

    // >
    operator fun compareTo(obj: Operations): Int {
        return value.compareTo(obj.value)
    }

    // in
    operator fun contains(o: Operations): Boolean {
        return o.value in 0..value
    }


    //==,  ключевое слово operator можно и не уазывать
    override operator fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Operations

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value
    }
}