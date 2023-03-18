package generic

val <T> List<T>.penultimate: T
    get() = this[size - 2]

