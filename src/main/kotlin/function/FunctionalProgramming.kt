package function

fun main() {

    val list = mutableListOf<Int>()
    val listDouble = mutableListOf<MutableList<Int>>()

    for (i in 1..20) {
        list.add(i)
    }
    for (i in 1..10) {
        listDouble.add(list)
    }

    val strings = list
        .filter { it % 2 == 0 }
        .map { it.toString() }


    val double = listDouble.flatMap {
        it.filter {
            it % 2 == 0
        }
    }

    println(double)

}