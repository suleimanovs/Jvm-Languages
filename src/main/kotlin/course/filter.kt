package project.standart_functions

fun main() {
    var age= mutableListOf<Int>()
    for(i in 0..100){
        age.add(i) }
    //filter { number:Int->number % 2==0} можно укоротить, по скольку лишь один параметр, и Int
    var ages=age.filter {it % 2==0}




    var name=listOf<String>("Osman","Omar","asa","Aslan","Aziz","Sara")

    //filter{name:String-> name.toUpperCase().startsWith("A")} можно сократить
    var names=name.filter{it.toUpperCase().startsWith("A")}
    println(names)
}

