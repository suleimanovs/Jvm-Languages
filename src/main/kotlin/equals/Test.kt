package project.equals

/**
 * Created by Osman on 9:35 PM
 */
fun main() {

    //Ссылочные типы
    val userData1 = UserData("Osman")
    val userData2 = UserData("Osman")

    val userNoEquals1 = UserNoEquals("Osman")
    val userNoEquals2 = UserNoEquals("Osman")

    val userWithEquals1 = UserWithEquals("Osman")
    val userWithEquals2 = UserWithEquals("Osman")

    val string1: String = "Osman"
    val string2: String = "Osman"


    //Примитивные типы

    val integer1: Int = 10
    val integer2: Int = 10


    /**
     * В Kotlin есть два типа равенства:
     *  - Равенстов ссылок- ===
     *  - Равенстов структур -equals / ==
     */


    /**
     * первый способ(структурное равенство) == , сравнивает данные содержащийся в переменных,
     * для data классов она сравнивает их содержимое,
     * она так же сравнивает содержимое классов в которых преопределен метод equals()
     * А для всех остальных сравнивает их сслыки
     */
    println("userData1 == userData2: ${userData1 == userData2}")
    println("userNoEquals1 == userNoEquals2: ${userNoEquals1 == userNoEquals2}")
    println("userWithEquals1 == userWithEquals2: ${userWithEquals1 == userWithEquals2}")
    println("string1 == string2: ${string1 == string2}");
    println("integer1 == integer2: ${integer1 == integer2}\n")




    /**
     * второй способ ===, сравнивает ссылки двух переменных,
     * Однако в случае примитивов(Byte,Short,Int,Long,Float,Double,)
     * оператор === являеться эквивалентом ==, то есть сравнивает значение переменных
     */
    println("userData1 === userData2: ${userData1 === userData2}")
    println("userNoEquals1 === userNoEquals2: ${userNoEquals1 === userNoEquals2}")
    println("userWithEquals1 === userWithEquals2: ${userWithEquals1 === userWithEquals2}")
    println("string1 === string2: ${string1 === string2}");
    println("integer1 === integer2: ${integer1 === integer2}\n")


    /**
     * Третий способ  - метод equals работает по такому же принципу что и ==, они одинаковы,
     * созданы для сравнения структур, даже сам компилятор просит заменить equals на ==
     */
    println("userData1.equals(userData2): ${userData1.equals(userData2)}")
    println("userNoEquals1.equals(userNoEquals2): ${userNoEquals1.equals(userNoEquals2)}")
    println("userWithEquals1.equals(userWithEquals2): ${userWithEquals1.equals(userWithEquals2)}")
    println("string1.equals(string2): ${string1.equals(string2)}");
    println("integer1.equals(integer2): ${integer1.equals(integer2)}")


}