package project.course

fun main(){
    val result = modifyCollection(arrayListOf<Int>(1,2,3,4,5,6,4,3,3,2,4,5,6)) {   println("${it.sum()}")  }
    print(result)
}

fun modifyCollection(collection:List<Int>, modify: (List<Int>)->Unit){

    modify(collection)
}