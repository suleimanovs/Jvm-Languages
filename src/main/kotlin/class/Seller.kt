package `class`

class Seller(name: String, age: Int) : Worker(name, age), Cleaner {

    override fun work() {
        println("Sells good")
    }

    override fun clean() {
        println("Продавец убирает")
    }
}