package classes

import course.Country

/**
 * Created by user on 13:00
 */

/**
 * @data class - не похожи на обычных классов, основные различия:
 * - у них автоматический переопределены методы equals, toString, hashcode, copy (касается только основного контруктора)
 * - он должен иметь хотя бы один параметр в конструкторе, обьявленный с помощью val или var
 * - можно обращаться к переменным как component1(),component2() в зависомости от кол-во, благодаря этому поддерживается деструктизацию
 */
data class Info(val name: String , val age: Int)


fun main() {

    /**
     * @EQUALS
     * обычный класс по умолчанию вернул бы лож, так как проверяет ссылки, а не значение,
     * но data class вернет истину, так ка он сравнивает значения а не ссылки
     */
    Info("Osman" , 19).equals(Info("Osman" , 19))


    //сравнение ссылок
    Info("Osman" , 19) === (Info("Osman" , 19)) //false


    /**
     * @toString
     * обычный класс вернул бы что-то вроде  Info@3858i4,
     * но data class вернет Info(name = "Osman", age= 19)
     */
    Info("Osman" , 19).toString()


    /**
     * @COPY
     * для копирование есть такой метод как [copy], только для классов данных,
     * @data_class, мы копировали все у [info] за исключением параметра [Info.age],
     * его мы изменили при присвоений
     */
    val info = Info("Osman" , 19)
    val copyInfo = info.copy(age = 20)


    /**
     * @Destructization - data class так же поддерживает деструктизацию
     * a получить значение name б получить значение age, но в принципе любой класс можно
     * сделать деструктивным
     */
    val (a , b) = Info("Osman" , 19)
    val (c , d) = Country("Astana" , 20300)


}
