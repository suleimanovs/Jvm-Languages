package course



fun main() {
    val list= listOf(1,2,3,4,5,6)
    println(joinToStringV2(list,";"))
    println(list.joinToStringV1("; ","{","}"))

   var x= X(124, 33)
    x.x()

}

fun <T> Collection<T>.joinToStringV1(separator:String,prefix: String,postfix: String): String{
    val result = StringBuilder(prefix)
    for (i in this) {
        result.append("$i$separator")
    }
    result.append(postfix)
    return result.toString()
}


fun <T> joinToStringV2(collection:Collection<T>,separator:String,prefix:String="{",postfix:String="}"):String {
    val result = StringBuilder(prefix)

    for (i in collection) {
        result.append("$i$separator ")
    }
    result.append(postfix)
    return result.toString()
}

interface A {
    fun myFunction(){println("from A")}
}

open class B(val sus:Int,val suz:Int=10) {
    open fun myFunction() {
        println("from B")
    }
}


class X(sus:Int,suz:Int) : B(sus,suz) {
  fun x(){
      if(sus>suz){
          super.myFunction()
      }
  }
}