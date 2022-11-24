package cycle;

/**
 * Created by Osman on 11:17 AM
 */
public class Cycle {
    public static void main(String[] args) {


        /**
         * Cycle While
         * break - приостанавливает цикл
         * continue - пропускает итерацию, все операций после этого слово не выполняются
         * return - также приостонавливает цикл
         * */
        int a = 100;
        while (a > 0) {
            a--;
            if (a % 2 == 0) continue;
            if (a == 29) break;
            System.out.println(a);
        }


        /**
         * Cycle Do While
         * точно такая же как и while, с отличием того что код внутри блока [do] выполниться один раз,
         * а потом провериться логическое значение внутри цикла.
         * */
        do {
            a--;
            if (a % 2 == 0) continue;
            if (a == 29) break;
            System.out.println(a);
        }
        while (a > 0);


        /**
         * For
         * через запьятую так же можно указать дополнительные операций
         * */
        for (int i = 0; i < 10; i++) {
            System.out.println(12);
        }



        /**
         * For
         * через запьятую так же можно указать дополнительные операций
         * */
        int[] integers = {2, 3, 5, 8, 9, 6, 5, 5, 4};
        for (int integer: integers) {
            System.out.println(integer);
        }


    }
}
