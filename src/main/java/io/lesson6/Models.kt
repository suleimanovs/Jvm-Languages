package io.lesson6

import java.io.Serializable

/**
 * Created by Osman on 18:25
 */
data class Address(val street: String , val numberOfHouse: Int) : Serializable
open class Person(val name: String , val lastname: String) : Serializable

class User(name: String , lastname: String , private val age: Int , @Transient val address: Address) :
    Person(name , lastname) , Serializable {


    override fun toString() = "User(name: $name lastname: $lastname age: $age address: $address)"

}