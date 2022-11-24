package variables;

public class OverloadPriority {

    void abc(int a) {
        System.out.println("abc(int a)");
    }

    void abc(long a) {
        System.out.println("abc(long a)");
    }

    void abc(Integer a, Integer b) {
        System.out.println("abc(Integer a, Integer b)");
    }

    void abc(int...a) {
        System.out.println("abc(int...a)");
    }

    public static void main(String[] args) {
        /**
         * Если при вызове метода, его список параметров соответствует нескольким списком параметров других overload
         * методов, то приоритет их вызова следующий:
         * 1. Точное совпадение типов данных.
         * 2. Поглощающие типы данных(большие типы данных для примитивов, и parent классы для reference типов)
         * 3. Autoboxed типы данных.
         * 4. Vararg.
         */
    }
}
