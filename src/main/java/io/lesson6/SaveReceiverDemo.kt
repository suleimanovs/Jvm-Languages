package io.lesson6

import java.io.*

/**
 * Created by Osman on 17:50
 *
 * 1. Сериализация - процесс преобразования объекта в поток байтов.
 * 2. Десериализация-процесс создания объекта из потока байтов.
 * 3. Для того чтобы объект можно было сериализовать, необходимо, чтобы класс реализовал интерфейс Serializable.
 * 4. Все поля сериализуемого класса тоже должны быть сериализуемы, либо помечены ключевым словом transient.
 * 5. Ключевое слово transient запрещает сериализовать поле.
 * 6. Все классы,
 * Так же можно использовать класс Externalaziable, делать сериализацию и десериализацию вручную
 */
fun main() {

    val file = File("file/sub/person/user.usr")
    if (!file.exists()) file.createNewFile()


    /**
     * Для того что бы сохранять объект, он должен быть сериализован,
     * то есть класс должен реализовать интерфейс Serializable(маркер).
     */
    val user = User("John", "Smith", 25, Address("Timur", 13))
    val objectOutputStream = ObjectOutputStream(FileOutputStream(file))
    objectOutputStream.writeObject(user)

    /**
     * Если после сохранения объекта в файл, то при чтении этого объекта, класс не должен изменяться,
     * если он был изменен, то переменная должна быт помечена как transient,
     * то есть этот объект получить значение null(для ссылочных).
     * При десериализации не вызвается контруктор. Объект строится напрмую из засписанных данных
     */
    val objectInputStream = ObjectInputStream(FileInputStream(file))
    val savedUser: User = objectInputStream.readObject() as User
    println(savedUser.toString())

}

/**
 * Для того чтобы объект класса можно было сериализировать, класс должен имплементировать
 * интерфейс Serializable(интерфейс маркер). Поля класса, помеченные ключевым словом transient, не записываются в файл при сериализации.
 * В сериализируемом классе необходимо использовать serialVersionUID для обозначения версии класса
 */
data class Address(val street: String, val numberOfHouse: Int) : Serializable
open class Person(val name: String, val lastname: String) : Serializable

/**
 * Если класс сериализуемый, то его родитель тоже должен бы быть серилизуемым,
 * либо должен содержать конструктор без параметров
 */
class User(name: String, lastname: String, val age: Int, @Transient val address: Address) : Person(name, lastname) {

    val serialVersionUID = 1339499493939393L

    init {
        println("created an object$this")
    }

    override fun toString() = "User(name: $name lastname: $lastname age: $age address: $address)"

}
