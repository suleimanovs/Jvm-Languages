package stream_api;

/**
 * Created by Osman on 5:59 PM
 */
public class Part1 {

    public static void main(String[] args) {
        MyNumber myNumberFull = new MyNumber() {
            @Override
            public double getValue(int n, int m) {
                return n + m + 2;
            }
        };
        myNumberFull.getValue(12, 14);


        /**
         * Запись выше можно сократить до такого:
         * При этом возращать значение с помощью return не требуеться,
         * так как тело функций состоит из одной строки
         */
        MyNumber myNumberLambda = (int n, int m) -> n + m + 2; //определяем тело лямба функций
        myNumberLambda.getValue(3, 4); //вызываем лямбу функцию и передаем аргументы


        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
            }
        }).start();


        /**
         * Такой подход создания функций возможно только с функциональными интерфейсами,
         * Функциональный интерфейс - интерфейс который имеет только с одним абтрактным методом.
         * Подробнее см: {@link MyNumber}
         */
        new Thread(() -> System.out.println(1)).start();
    }
}

/**
 * Функциональный интерфейс - это интерфейс который содержит только один и только абстрактный метод.
 * Он может содержать другие статические методы и методы по умолчанию, но  абстрактный метод
 * должен быть только один. Но при этом он так же может имет методы о умолчанию(с реализацией)
 * <p>
 * Так же можно добавить анотацию @FunctionalInterface которая уведомляет компилятор,
 * что интерфейс является функциональным
 */

@FunctionalInterface
interface MyNumber {
    double getValue(int n, int m);
}