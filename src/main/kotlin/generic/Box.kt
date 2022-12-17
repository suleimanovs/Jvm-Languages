package generic

import java.io.Serializable

/**
 * [T] - сокращено от type , но вместо него можно использовать любую букву, но принято
 * [R] - return ,[E] - element, [K] - key, [V] - value
 * здесь <T> говорит о том что этот класс использует обобщение, на данный момент  [T]
 *
 */
class Box<T : Number>(val item: T)

/**
 * Верхняя граница по умолчанию (если она не была указана) Внутри угловых скобок может быть указана только одна верхняя граница.
 * Если для одного и того же параметра типа требуется более одной верхней границы, необходимо отдельное предложение where-clause
 */
class Bag<T>(val item: T) where T : Number, T : Comparable<T>, T : Serializable


fun main() {
    val boxOfInt = Box<Int>(12)
    val boxOfFloat = Box<Float>(12f)

}