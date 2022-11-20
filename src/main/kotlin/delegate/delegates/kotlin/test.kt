package delegate.delegates.kotlin

/**
 * Created by osmanboy on 3/2/2022
 */

interface A {
    fun test()
}

class AImpl : A {
    override fun test() = println("AImpl")
}

class BImpl : A{
    override fun test() = println("BImpl")
}


fun newInstance() = BImpl()

class Test : A by AImpl() {
    override fun test() = println("Test")
}

fun main() {
    Test().test()
}
class Test2 : A by newInstance()