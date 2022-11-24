package cycle;

public class For {
    public static void main(String[] args) {


        /**
         * первый блок - initialization (вызывается только один раз)
         * второй блок - condition state
         * трнетий блок -  update state
         */
        for (int i = 0; i < 1; i++) {
            System.out.println(i);
        }

        /**
         * цикл можно остановить, можно пропустить итерацию
         */
        for (int k = 0; k < 10; k++) {
            if (k == 5) {
                continue; //код после continue не будет выполянться
            }
            System.out.println("я продолжение");

            if (k == 9) {
                break; //код после break не будет выполянться
            }
            System.out.println("я продолжение");

        }


        int i = 0;
        for (int j = i; j < 1; j++) {
            System.out.println(i);
        }

        /**
         * если переменная уже существует, то первый state можно проспустить
         */
        int j = 0;
        for (; j < 1; j++) {
            System.out.println(i);
        }

        /**
         * можно в первом state обьявить несколько переменных, но все они должны бы быть одного типа
         */
        for (int k = 0, s = 1, r = 2; k < 1; k++) {
            System.out.println(i);
        }

        for (float k = 0f, s = 1, r = 2; k < 1; k++) {
            System.out.println(i);
        }


        /**
         * condition state и update state тоже можно сделать длинее, добавляя больше проверок, и обнавлении
         */
        for (int k = 0, s = 1; k < 10 && s < 10; k++, s++) {
            System.out.println(i);
        }


        /**
         * в update statement можно дажае вызвать другие методы
         */
        for (int k = 0; k < 2; k++, increment(k)) {
            System.out.println();
        }

        /**
         * update state можно и не написать в сигнатуре for, в данном случае нет никакой разницы в сравнений с обычным
         * использованием for
         */
        for (int k = 0; k < 10; ) {
            System.out.println(k);
            k++;
        }

        /**
         * цикл for можно сделать бесконечным , как while, достаточно просто не указать update state
         */
        for (int k = 0; k < 10; ) {
            System.out.println(k);
            for (;;){} //бесконечный
        }


        /**
         * цикл for можно сделать бесконечным , как while, пропустив condition state
         */
        for (int k = 0; ; k++) {
            System.out.println(k);
        }


    }

    static void increment(int i) {
        i++;
        System.out.println(i);
    }
}

class ForExpression {

    public static void main(String[] args) {
//        alarm(12, 12);
        alarm2(10, 4);
    }

    public static void alarm(int h, int m) {

        for (int hour = 0; hour < 24; hour++) {

            /**
             * мы вынесли эту переменную во внешний loop, что бы мы могли остановить и внешний loop
             */
            int minute = 0;
            for (; minute < 60; minute++) {
                System.out.println(hour + " : " + minute);
                if (hour == h && minute == m) {
                    break;// этот break остановит только внутренний loop, внешний продолжить свою работу(итерацию)
                }
            }
            /**
             * когда if (hour == h && minute == m) вернет true, внутреннрий loop будет остановлен
             * управление вернется внешенему loop, и во внешнем loop-e мы сделаем еще провреку и остановим его
             * при необхадимсоти
             */

            if (hour == h && minute == m) {
                System.out.println("Будильник звенит!");
                break;// этот break остановит внешний loop
            }


        }

    }


    /**
     * способ с помощью expression-ов, этот способ более правильный и рекомендуемый
     */
    public static void alarm2(int h, int m) {

        OUTER:
        for (int hour = 0; hour < 24; hour++) {

            for (int minute = 0; minute < 60; minute++) {

                System.out.println(hour + " : " + minute);
                if (hour == h && minute == m) {
                    System.out.println("Будильник звенит!");
                    break OUTER;// этот break остановит внешний loop
                }

            }

        }

    }

}
