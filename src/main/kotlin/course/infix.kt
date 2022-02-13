package course

class Dogs {
    infix fun bark(x: Int): String {
        return x.toString()
    }

}

/**
 * если функция отмечена этим ключевым слово то можно отбросить все знаки вроде точки и скобок
 */
fun main() {
    //infix- позваляет вызывать функцию без исполбзования точечной записи
    Dogs().bark (6)
    Dogs() bark (6)
    Dogs() bark 6
}