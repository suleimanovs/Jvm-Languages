package classes

class Student private constructor(val name: String, val age: Int) {

    var address: String

    /**
     * Kotlin можно указать блок инициализации для класса. Блок инициализации — это способ настроить
     * переменные или значения, а также произвести их проверку, то есть убедиться,
     * что конструктору переданы допустимые аргументы. Код в блоке инициализации
     * выполняется сразу после создания экземпляра класса.
     * Первыми инициализацию получают параметры в конструкторе.Затем вызываются instance init блоки. а после тела конструкторов
     */
    init {
        println(name)
        println("init block 1")
        address = "Shymkent"
    }

    constructor(name: String) : this(name, -1) {
        println("second constructor")
    }


    constructor() : this("Unknown"){
        println("third constructor")
    }

    init {
        println("init block 2")
        address = "Astana"
    }

    companion object {

        /**
         * Как и в Java, static init block-и вызываются еще до создания объекта, они вызываются сразу же как класс
         * загружается в память. Если создать init block внутри тела класса, то они вызываются при созданиях объекта.
         * Если создать init block внутри companion object, то он становится статическим блоком
         */
        init {
            println("First static init block")
        }

        var s: String

        init {
            s = "Second"
            println("$s static init block")
        }

    }

}

fun main() {
    Student("Billy")
}
