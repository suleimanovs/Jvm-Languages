package project.course

fun main() {
    val db=Database
    val tst= Test()
    db.insert("1")
    db.insert("2")
    tst.insert("3")

}



object Database {

    val data = mutableListOf<String>()
    fun insert(str: String) =data.add(str)

}


class Test{
    fun insert(string:String)= Database.insert(string)

}