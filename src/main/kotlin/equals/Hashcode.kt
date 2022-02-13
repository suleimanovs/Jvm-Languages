package equals

/**
 * Created by IntelliJ IDEA.
 * Author: osmanboy
 * Date: 1/23/2022
 * Time: 1:05 PM
 * Project name: Jvm-Languages
 */
class Real(val name: String, val age: Int){

    override fun equals(other: Any?): Boolean {
        //Сылаются ли два экземпляра на один и тот жн объект
        if (this === other) return true

        //Названия классов единтично или нет
        if (javaClass != other?.javaClass){
            println("Тип не совпадает")
            return false
        }

        other as Real

        //переменная name не равна ли перемнной name другова сравняемого класса
        if (name != other.name) return false
        if (age != other.age) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + age
        return result
    }

    override fun toString(): String {
        return "Real(name='$name', age=$age)"
    }


}