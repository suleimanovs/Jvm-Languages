package course

import kotlin.random.Random

fun main() {


    // 1 вариант без companion object
    val square = CustomMath()
    println(square.square(12))


    //2 вариант с companion object
    /**
     * Но зачем  для рассчетов создать объект,для решения есть companion object
     */
    println(CustomMath.square(12))

    println("${Test.random}")

    println(MyRandom.randomBoolean())


}


/**
 * Скажем мы создали класс для  математических вычеслений
 * что бы его вызвать нам нужно создать  экземпляр класса
 */
class CustomMath {
    fun square(num: Int) = num * num

    /**
     *  В классе может быть лишь одинь companion , так же ему не доступны поля класса
     */
    companion object {

        fun square(num: Int) = num * num

    }
}


/**
 * Создать экземпляры класса из вне не получиться так как его конструктор приватный
 */
class Test private constructor() {

    /**
     * Как окозалось инициализируеться лишь одинь раз , в последующие разы уже возвращает
     * инициализированные данные
     */
    companion object {
        init {
            println("Called")
        }

        val random = Random.nextInt()
    }


}

class MyRandom {

    /** companion object(вспомогательный класс)- позволяет вызвать функцию из класса, без не обходимости присвоить
    класс к кокомуто объекту, к примеру так делать нету не обходимости var myClass= MyRandom()  -> myClass.randomInt(..)
    можно ему и название дать. В одном классе не может быь больше одного вспомагательного класса
     */
    companion object {

        fun randomInt(number: Int , to: Int): Int {
            return Random.nextInt(number , to)
        }

        fun randomBoolean(): Boolean {
            return Random.nextBoolean()
        }

        fun randomWeekDay(): String {
            val arrayOf =
                listOf("Понедельник" , "Вторник" , "Среда" , "Четверг" , "Пятница" , "Суббота" , "Воскресенье")
            return arrayOf.shuffled().first()
        }
    }
}
