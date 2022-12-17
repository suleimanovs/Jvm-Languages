package generic
/**
 * этот класс используется для проведения выставок разных типов животных, с его помощью мы будем
 * управлять оценками участников для опрерделения победителья
 */
class Contest<T : Pet>(var vet: Vet<T>) {

    private val scores: MutableMap<T , Int> = mutableMapOf()

    fun addScore(t: T , score: Int = 0) {

        if (score >= 0) scores[t] = score
    }


    fun getWinners(): MutableSet<T> {

        val max = scores.values.maxOrNull()
        val winners: MutableSet<T> = mutableSetOf()

        for ((t , score) in scores) {
            if (score == max) winners.add(t)
        }
        return winners
    }

    /**
     * [where] - ограничивает параметр функций теми типами которых мы указали,
     * попытка передать в функцию тип отличного от этого будет вызвана ошибка
     */
    fun <T> getIntAndFloat(number: T) where T : CharSequence , T : Appendable {
        number.append("exa")
    }

}
/**
 * Если обобщенный тип помечается ключевым словом [out],это обобщенный тип называеться[ковариантным]
 * То есть, это озночает что обобщенный подтип может использоваться вместо обобщенного супертипа
 * Префикс [out] не может использоваться, если класс имеет функций с параметрами принимающие параметризованный тип
 * или var - свойство этого обобщенного типа, [out] используется только в выходных позициях
 */
interface Retailer<out T> {
    fun sell(): T
}

class CatRetailer : Retailer<Cat> {
    override fun sell(): Cat {
        println("Sell Cat")
        return Cat("")
    }
}

class DogRetailer : Retailer<Dog> {
    override fun sell(): Dog {
        println("Sell Dog")
        return Dog("")
    }
}

abstract class Pet(var name: String)

class Cat(name: String) : Pet(name)

class Dog(name: String) : Pet(name)


/**
 * Если обобщенный тип помечается ключевым словом [in],это обобщенный тип называется[контвариантным]
 * То есть, это означает что обобщенный супер тип может использоваться вместо обобщенного подтипа
 * Префикс [in] полная противоположность [out], Другими словами мы можем использовать супертип
 * вместо подтипа, Контравариантность противоположна ковариантности.
 * Обобщенный тип класса или интерфейса может снабжаться префиксом in, если класс содержит
 * функций, использующие его в качестве типа параметра. При этом in не может использоваться. Если
 * какие-либо функций класса используют его в качестве возвращаемого типа, так же если этот тип
 * используется какими-либо свойствами(независимо var / val)
 */
class Vet<in T : Pet> {
    fun treat(t: T) {
        println("Treat Pet ${t.name}")
    }
}

fun main() {

    // 3 поле работает потому что interface Retailer помечен как out(ковариантным)
    val dogRetailer: Retailer<Dog> = DogRetailer() // Retailer<Dog>
    val catRetailer: Retailer<Cat> = CatRetailer() // Retailer<Cat>
    val petRetailer: Retailer<Pet> = CatRetailer() // Retailer<Cat>


    val catVet = Vet<Cat>()
    val petVet = Vet<Pet>()


    catVet.treat(Cat("Fuzz Lightyear"))
    petVet.treat(Cat("Katsu"))
    petVet.treat(Dog("Finny McGraw"))


    // первое поле работает потому что class Vet помечен как in(контравариантным)
    val catContest = Contest<Cat>(petVet)//(var vet: Vet<T>)  - Vet<Pet>()
    val petContest = Contest<Pet>(petVet)

}