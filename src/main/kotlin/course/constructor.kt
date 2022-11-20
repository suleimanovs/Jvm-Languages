package course

fun main() {

    val country = Country("Osman" , 12)

    /**
     * Что бы копировать значение одного объекта в другой, просто присвоить
     * не получиться, они оба ссылаются на один и тот же объект, переменные лишь
     * хранят ссылки на эти обЪекты, компилятор выдасть true, потому что они
     * хранят ссылку на один и тот же обЪект
     */
    var country1 = country
    println(country.equals(country))




}

/**
 * Class-может иметь только один первичный конструктор,
 * и вторичных сколько угодно
 */
 class Country(var name: String , var population: Long) {

    var city: String = ""

    /**
     * При созданиях вторичного конструктора нужно вызвать основной с помощью [this]
     */
    constructor(name: String , population: Long , _city: String) : this(name , population) {
        this.city = _city

    }


    //пустой конструктор который ссылается на другой вторичный клас
    constructor() : this("" , 1 , "")


    /**
     * У классов данных такая поддержка есть по умолчанию,
     * но что бы обычный класс поддерживал деструктизацию:
     */
    operator fun  component1() = name
    operator fun  component2() = population

}