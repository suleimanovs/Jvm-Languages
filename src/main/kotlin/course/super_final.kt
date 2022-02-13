package course

fun main() {
    val employee= Manager("ITK","Osman")
    println(employee.fullInfo)
}



open class Person(val name : String){
    open val fullInfo: String
        get()="Name $name !"
    open fun display(){ println("name: $name") }
}



open class Employee(val company: String,name:String): Person(name){
    /**
     * если написать final перед override, то его будет
     * не возможно переопределять в классе manager
     */
    override fun display(){ println("name: $name, company: $company") }
}




class Manager(company: String,name:String): Employee(company,name){

    override val fullInfo: String
        /**
         * с помощью super мы обратились к реализацией из базового,
         * если не понял то просто запусти код и поймешь
         */
        get() = super.fullInfo

    override fun display(){
        println("name: $name, company: $company")
    }
}