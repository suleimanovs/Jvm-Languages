package constructions;

import java.util.Random;

public class TernaryOperator {
    public static void main(String[] args) {


        boolean bool = new Random().nextBoolean();
        /**
         * это не только конструкция, но и выражение, то есть он возвращает результат
         * в java if/else это только конструкций, не выражения
         */
        int id = bool ? 11 : 12;
        System.out.println(id);


        bool = new Random().nextBoolean();
        //оба варианта единтичны
        if (bool) {
            id = 11;
        } else {
            id = 12;
        }

        System.out.println(id);

    }
}
