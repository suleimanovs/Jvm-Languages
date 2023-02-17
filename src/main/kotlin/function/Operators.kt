package function

class Operators(var value: Int) {

    val TAG = 14
    val array = intArrayOf(1, 2, 4)

    /**
     * Теперь объекты данного класса поддерживают мульти декларацию. То есть мы можем так:
     * val (value,tag) = Operations(12). тогда у value будет зачение 12, а у tag будет 14
     */
    operator fun component1() = value
    operator fun component2() = TAG


    /**
     * Kotlin позволит нам использовать оператор "+" и тогда будет использована функция [plus],
     * после компиляций везде где использованы символы операторов будут заменены на соответствующие функций.
     *
     * <pre>{@code
     *  val o1 = Operators(11)
     *  val o2 = Operators(22)
     *  val result = o1 + o2  // 33
     * }</pre>
     *
     * после компиляций будет так:
     * val result = o1.plus(o2)
     */
    // +
    operator fun plus(other: Operators) = Operators(value + other.value)

    // -
    operator fun minus(other: Operators) = Operators(value - other.value)


    // ++
    operator fun dec() = Operators(value + 1)

    // --
    operator fun inc() = Operators(value - 1)

    //*/
    operator fun times(other: Operators) = Operators(value * other.value)

    // /
    operator fun div(other: Operators) = Operators(value / other.value)

    // () //можно вызвать класс как функцию
    operator fun invoke(s: String, d: Double) = println("invoke")

    // () // перегруженный invoke
    operator fun invoke(s: String) = println("invoke")

    // [12]
    operator fun get(i: Int) = i * value

    // [0] = 15
    operator fun set(i: Int, v: Int) {
        array[i] = v
    }

    // >
    operator fun compareTo(obj: Operators): Int {
        return value.compareTo(obj.value)
    }

    // in
    operator fun contains(o: Operators): Boolean {
        return o.value in 0..value
    }


    //==,  ключевое слово operator можно и не уазывать
    override operator fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Operators

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value
    }
}
