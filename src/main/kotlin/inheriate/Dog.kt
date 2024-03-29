package inheriate

/**
 * Наш класс поскольку наследуется, мы должны передать значения в конструктор супер класса,
 * название животного всегда будет [Собака] , среда обитания [Cуша]
 * и у нас уже есть переменная в суперклассе обявленная словом var,
 * от родительского класса мы переняли только один параметр [weight],
 * и будем его иницализировать при мсоздания экземпляра
 */
open class Dog(weight: Float): Animal("Собака",weight,"Суша"){
    override val dangerLevel = super.dangerLevel - 3


    override fun eat() {
        println("Кушаю кость")
    }

}