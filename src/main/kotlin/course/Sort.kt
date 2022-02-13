package project.course

fun main() {


    fun sort( list : MutableList<Int>): List<Int> {

        var temp = 0


        // предположим что в списке 10 элементов, массив начнинает сразу с 1 до 10 не включительно
        for (j in 1 until list.size ) {

            //массив всегда начнется с итерератора(9) к 1 эелементу  до j элемента назад
            for(i in list.size -1 downTo j){


                if (list[i] < list[i - 1]) {
                    temp =
                        list[i]
                    list[i] =
                        list[i - 1]
                    list[i - 1] =
                        temp
                }
            }

        }


        return list.toList()
    }

    println(sort(arrayListOf(1,3,7,2,7,9,4,2,6,8,5,4,7,9,4,2,6,8,5,4,7,9,4,2,6,8,5,4,7,9,4,2,6,8,5,4,7,9,4,2,6,8,5,4,7,9,4,2,6,8,5,4,7,9,4,2,6,8,5,4,7,9,4,2,6,8,5,4)))

}