package course

//
//interface Messenger {
//    fun send(message: String)
//}
//
//class InstantMessenger(val programName: String) : Messenger {
//    override fun send(message: String) {
//        println("Message `$message` has been sent")
//    }
//}
//
///**
// * Здесь мы не обязаны реализовать интерфейс блогодаря делегированию
// */
//class SmartPhone(val name: String , m: Messenger) : Messenger by m
//fun main() {
//    val telegram = InstantMessenger("Telegram")
//    val pixel = SmartPhone("Pixel 5" , telegram)
//    pixel.send("Hello Kotlin")
//}


interface Base {
    fun print()
}

class BaseImpl(private val x: Int) : Base {
    override fun print() { print(x) }
}

class Derived(b: Base) : Base by b

fun main() {
    val b = BaseImpl(10)
    Derived(b).print()
   val d =  Derived(b)
    d.print()
}


