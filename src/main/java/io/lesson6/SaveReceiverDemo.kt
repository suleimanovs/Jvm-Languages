package io.lesson6

import java.io.*

/**
 * Created by Osman on 17:50
 *
 * 1. Сериализация - процесс преобразования объекта в поток байтов.
 * 2. Десериализация- процесс создания объекта из потока байтов.
 * 3. Для того чтобы объект можно было сериализовать, необходимо, чтобы класс реализовал интерфейс Serializable.
 * 4. Все поля сериализуемого класса тоже должны быть сериализуемы, либо помечены ключевым словом transient.
 * 5. Ключевое слово transient запрещает сериализовать поле.
 * 6. Все классы,
 */
fun main() {
    val file = File("Package1/user.usr")
    file.createNewFile()


    /**
     * Для того что бы сохранять объект, он должен быть сериализован,
     * то есть класс должен реализовать интерфейс Serializable(маркер).
     */
    val user = User("John" , "Smith" , 25 , Address("Timur" , 13))
    val objectOutputStream = ObjectOutputStream(FileOutputStream(file))
    objectOutputStream.writeObject(user)

    /**
     * Если после сохранения объекта в файл, то при чтении этого объекта, класс не должен изменяться,
     * если он был изменен, то переменная должна быт помечена как transient,
     * то есть этот объект получить значение null(для ссылочных)
     */
    val objectInputStream = ObjectInputStream(FileInputStream(file))
    val savedUser: User = objectInputStream.readObject() as User
    println(savedUser.toString())


}
