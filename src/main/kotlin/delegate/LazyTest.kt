package delegate

fun main() {
    val lazyTest = LazyTest()
    lazyTest.x
    lazyTest.x
}

class LazyTest {

    val x by lazy {
        println("initial")
        12
    }

}