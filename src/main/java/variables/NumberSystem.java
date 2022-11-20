package variables;


public class NumberSystem {

    /**
     * Существует четыре типа систем счисления в языке программирования Java:
     * <p>
     * Двоичная система счисления [Binary Number System]
     * Восьмеричная система счисления [Octal Number System]
     * Десятичная система счисления [Decimal Number System]
     * Шестнадцатеричная система счисления [Hexadecimal Number System]
     */

    public static void main(String[] args) {

        /**
         * Двоичная система счисления [Binary Number System]
         *
         * В этой системе счисления мы используем «0b» (0b озночает что он двоичный/бинарный) в качестве префикса для
         * преобразования двоичного файла в целочисленный формат.
         * interval: 0-1
         * Выходные данные для приведенного выше примера равны 50.
         */
        byte byteBinary = 0b00110010;
        short shortBinary = 0b00110010;
        char charBinary = 0b00110010;
        int intBinary = 0b00110010;
        long longBinary = 0b00110010L;
        Object[] binary = {byteBinary, shortBinary, charBinary, intBinary, longBinary};
        System.out.println("Двоичная система счисления [Binary Number System]:");
        for (Object b : binary) System.out.println(b);


        /**
         * Восьмеричная система счисления [Octal Number System]
         *
         * В этой системе счисления мы используем «0»  в качестве префикса для
         * преобразования восьмеричного формата в целочисленный формат.
         * interval: 0-7
         * Выходные данные для приведенного выше примера равны 50. (не 62)
         */
        byte byteOctal = 062;
        short shortOctal = 062;
        char charOctal = 062;
        int intOctal = 062;
        long longOctal = 062L;
        Object[] octal = {byteOctal, shortOctal, charOctal, intOctal, longOctal};
        System.out.println("Восьмеричная система счисления [Octal Number System]:");
        for (Object o : octal) System.out.println(o);


        /**
         * Десятичная система счисления [Decimal Number System]
         *
         * В этой системе счисления это нормальные десятичные значения,
         * которые мы называем целыми числами.
         * interval: 0-9
         * Выходные данные для приведенного выше примера равны 50.
         */
        byte byteDecimal = 50;
        short shortDecimal = 50;
        char charDecimal = 50;
        int intDecimal = 50;
        long longDecimal = 50L;
        Object[] decimal = {byteDecimal, shortDecimal, charDecimal, intDecimal, longDecimal};
        System.out.println("Десятичная система счисления [Decimal Number System]:");
        for (Object d : decimal) System.out.println(d);


        /**
         * Шестнадцатеричная система счисления [Hexadecimal Number System]
         *
         * В этой системе счисления мы используем «0x»(озоначает hex)
         * в качестве префикса для преобразования шестнадцатеричного формата в целое число.
         * interval: 0-F
         * Выходные данные для приведенного выше примера равны 110.
         */
        byte byteHex = 0x6e;
        short shortHex = 0x6e;
        char charHex = 0x6E; // E-e одно и тоже для hex
        int intHex = 0x6e;
        long longHex = 0x6eL;
        Object[] hexadecimal = {byteHex, shortHex, charHex, intHex, longHex};
        System.out.println("Шестнадцатеричная система счисления [Hexadecimal Number System]:");
        for (Object h : hexadecimal) System.out.println(h);

    }

}
