package course

data class Cat(val name: String, val age: Int, val weight: Int)

val cats = listOf(Cat("Mur", 5, 7) , Cat("Null", 4, 7))

fun main() {

    //*************************COLLECTION*******************************
    val myList = listOf(0, 1, 2, 3, 4, 5)
    val array = arrayOf(1, 2, 3, 4, 5, 6, 6)
    val originalMap = mutableMapOf<String, Int>()

    cats.associate { Pair(it.name, it.age) }//перебирает лист, и создает Map
    cats.associateTo(originalMap) { it.name to it.age }// перебирает список, и передает ключ и значение пустому Map
    cats.maxByOrNull { it.age }// максимальное число
    cats.minByOrNull { it.age }// минимальное число
    cats.maxWithOrNull(Comparator { cat1 , cat2 -> cat1.name.length + cat2.name.length })
    cats.groupBy { it.age } //группирует, сортирует список котов по их возрасту


    myList.size //измеряет размер списка
    myList[0]; myList.get(0) //делают одно и тоже,  но если такого индекса нет то вызвут  ArrayIndexOutOfBoundsException
    myList.getOrElse(5) { "default" } // это метод решение проблемы первого варианта
    myList.getOrNull(5) //вернет null, но можно и обработать с помощью "?:" к примеру ?: 0
    myList.any { it == 2 }//тоже цикл, перебирает, и если хоть один элемент будет равен 2 то вернет true
    myList.all { it < 7 }// тоже что и any, только она вернет true если все элементф вернут true для условий
    myList.average() //подсчитывает среднее значение всех элементов
    myList.none { it > 6 } //true, с помощью none проверяем что ни один из элементов не выполняют условике
    myList.containsAll(listOf(1, 3)) // позволяет проверить сразу несколько элементов
    myList.count { it > 4 } // 1 проверяет сколько элементов больше указанного числа, и выводит количество найденных
    myList.fold(0) { one, two -> one + two } //собирает все знчаения в списке
    myList.first { it % 2 == 0 } //первый элемент,но если элемента нет, то исключение так же есть firstOrNull
    myList.foldRight(0) { one, two -> one + two } //тоже что и fold только значения берутся от последнего к первому
    myList.filterNotNull() //вернет список не содержающий null
    myList.reduce { one, two -> one + two } //тоже что и fold только без указания начального значения
    array.reverse() // делает реверс оригинала
    array.reversedArray() //делает реверс копию, оригинал не трогает
    myList.reversed() //делает реверс копию, оригинал не трогает
    println(array.contentToString()) //выводит все жлементы из массива, без этой функций работало бы совсем иначе


    myList.dropLast(3) // перебирая с последнего до первого пока не найдет его, так же есть dropWhile
    myList.take(2) //оставить первые два эленмента, остальное удалить, а так же есть и takeLast, takeWhile
    myList.takeIf { it.contains(2) }
    myList.elementAt(3) //получать элемент по индексу
    myList.elementAtOrElse(3) { "def" } //если такого элемента нет, то знчаение по умолчанию, та же есть elementAtOrNull

    myList.last()// по такому же приниципу работает last() lastOrNull()
    myList.indexOf(3)// возвращает индекс указанного элмента / lastIndexOf, indexOfFirst()
    myList.sumBy { it + 5 } //45 -сначала увеличивает каждый элемент из списка на +5 а потом возвращет общую сумму
    myList.singleOrNull { it % 3 == 0 }
    myList.sorted() //возвращает новый отсортированный список, а старый остается без без изменений
    myList.sortedDescending() //наоборот от большого к маленькому 5,4,3,2,1,0
    myList.sortedBy { it } //антоним sortByDescending()
    myList.slice(listOf(1, 3, 4)) //[2,4,5] возвращает список по указанным индексам
    myList.shuffled() // вовзращает новый список с перемешанными элментами старого списка,(shuffle() - для изменяемого)
    myList.minus(3) //отнимает элмент из списка
    myList.partition { it % 2 == 0 } //([2,4,6],[1,3,5]) при значение true в одну группу, остальных вдругую
    myList.plus(4) // добавляет новый элемент
    myList.distinct() //возвращает уникальный список, удаляя дубликаты
    myList.distinctBy { } // можно задать некие услвоий, особенно для классов

//=====================================THE END=====================================
    val arrayList = arrayListOf<Any>(5, 4, 4, 4) // изменяемый список

    arrayList.add(33) //
    arrayList.remove(3)//
    arrayList.removeAt(3)//
    arrayList.set(1, 5); arrayList[1] = 5 //
    arrayList.add(1, 33)//
    arrayList.removeIf { it == 3 }//
    arrayList.removeAll { it == 2 }
    arrayList.indices // вернет диапозон индексы элементов в списке или массиве, к прмеру так -0..3, а если разгоянт по циклу то как обычно
    arrayList.retainAll { it == 3 } //оставить все элементы котоые вернут истину, остальных удалить
    arrayList.shuffle()//
    arrayList.addAll(myList)//
    arrayList.union(myList) // обьяденят два элмента, а также е оставляя дубликатов
    arrayList.zip(myList).toMap()
    arrayList.replaceAll { }
    arrayList.fill(5)//заменяет все элементы в списке данным элементом
    arrayList.joinToString()// превращает в строку все элменты списка



    var unic = arrayList.toSet().toList()  //это возвможность получить лишь уникальные значенияб
    // грамоздный способ
    unic= arrayList.distinct() //делает тоже самое



    //=====================================String=====================================
    val name  = "Osman|boy "

    name.trim()//возвращает строку без пустых пробелов, так же есть trimStart(), trimEnd()
    name.trim(',','.') // удаляет все эти символы из строки
    println(name.trimMargin("Os"))//возвращает строку без  этих символов




}