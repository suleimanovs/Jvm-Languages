package project.course

/**
 * Created by user on 18:41
 */

fun main() {
     val maker =  Maker("one","two")
    println(maker.name)
    println(maker.age)
}

class Maker(val object1: String, _object2: String){

    /**
     * поздняя инициализация , он должен быть иниализирован до обращения к ней
     */
    lateinit var age : String


    /**
     * блок инициялизаций, выполняется сразу после создания экземпляра класса
     */
    val name: String
    init {
        name = _object2
        age = "Initial"
    }


  /**@Отложенная инициализаций
   *  Если обращаться к этой переменной, которая ещё не инициализирована, то она выведеть как и
   *  @println("Initialized") так и значение ["I have info"], что бы добраться до значения она
   *  пройдет по телу лямбды, но при обращаений во второй раз она вернеёт своё значение - "Ihave info"
   *  так как она уже получила заначение при первой инициализаций
   */
    val info: String by lazy {
        println("Initialized")
        "I have info"
    }











}