package oop.static_final_multiarg;

/**
 * Created by Osman on 9:22
 */
public class MyMath {

    public static int square(int num) {
        return num * num;
    }

    public static double length(double radius) {
        /**
         * @static - для его вызова не нужно создать обьект класса
         * статические методы не могут ссылаться на перременные экземпляра,
         * они должны ссылатся на такие же статические переменные
         */
        return 2 * PI * radius;
    }

    public static double area(double radius) {
        return PI * radius * radius;
    }


    /**
     * final - помечается в трех случаях:
     * 1.Переменная завершенная, ее больше не получиться изменить(присвоить новое значение)
     * 2.Класс не доступен для наследования
     * 3.код класса не доступен для переопределения
     */
    private static final double PI = 3.14;


    /**
     * ... - оператор троеточие делает тоже самое что и vararg в kotlin,
     * принимает неопределенное количество параметров
     */
    public static int sum(int... numbers) {
        int sum = 0;

        for (int i : numbers) {
            sum += i;

        }
        return sum;

    }

}
