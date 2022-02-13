package project.course.oop.`class`

/**
 * Created by user on 18:48
 */

/**
 * Interface - не имеет конструктора, не может иметь экземпляра
 * Этот интерфейс получать не все подклассы Worker, лишь Programmer, Seller
 */
interface Cleaner {
    fun clean()
}