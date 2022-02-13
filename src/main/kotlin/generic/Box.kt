package project.course.generic.exmaple2

/**
 * [T] - сокращено от type , но вместо него можно использовать любую букву, но принято
 * [R] - return ,[E] - element, [K] - key, [V] - value
 * здесь <T> говорит о том что этот класс испоьзует обобщение, на данный момент  [T]
 */
class Box<out T>(val item: T){


}


fun main() {
    val boxOfString = Box("String")
    val boxOfAny: Box<Any> =boxOfString

}