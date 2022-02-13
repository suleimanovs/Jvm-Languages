package course

fun main() {
    val string="Osman"


    /** padStart- заполянет строку указанным символом начиная с левой стороны
     * padEnd- заполняет с левой стороны, и если им не передать второй параметр,
     * то они по умолчанию заполняют его пустой стракой
     */
    val padStart=string.padStart(10,'*')
    val endPad=string.padEnd(10,'*')


    println(string.isBlank() ) //true,если пустая строка, или пустые табуляций
    println(string.lastIndex  )//возврашает индекс последнего элемента
    println(string.capitalize())  //переводит в верхний регистр первый символ в строке
    println(string.decapitalize())  //делает все как раз наоборот
    println(string.drop(2) )//убираем первые два элемента
    println(string.dropLast(2)) //убираем два последних элемента
    println(string.dropWhile { it=='m' }) //перебирает пока не найдет элемент,если найдет, то вернет строку без этого символа
    println(string.dropLastWhile { it=='o' }) // делает тоже самое, только цикл начинается с конца строки
    println(string.lines()) //["Osman"] разбивает на массив,и если в строке есть переходы(\n), то примерно [O,s,m,a,n] вернет
    println(string.zipWithNext())  //[(O, s), (s, m), (m, a), (a, n)]
    println(string.removeRange(0..4)) //удаляем элементы по указанному диопозону
    println(string.removePrefix("Os")) //  ман
    println(string.removeSuffix("man")) //Oc

}