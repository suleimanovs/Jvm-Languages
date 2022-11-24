package variables;

import java.util.Locale;

/**
 * Created by osmanboy on 3/2/2022
 */
public class StringTest {

    /**
     * String - является не изменяемым(immutable), т.к String хранит свое значение в private массиве (char),
     * этот массив имеет фиксированную длину:
     * private final char[] value;
     * String хранит свое значение в final массиве, следовательно его инициализация может быть только один раз.
     * Ни один из методов класса String не изменяет индивидуальные элементы массива char.
     */
    public static void main(String[] args) {

        /**
         * когда мы создаем объекты string с помощью new, то всегда и всегда создается новый объект с новым значением
         * даже если уже существует еще один объект с таким же значением в String Pool. В данном случае Java игнорирует
         * то, что уже объект с таким значением уже есть в pool-e. Он создает новый объект.
         */
        String string1 = new String("String");
        String string2 = new String("String");

        /**
         * в java, класс String единственный класс(не считая обертки примитивов), чьи объекты мы можем создавать вот так:
         * когда мы создаем объекты string в таком виде. То джава не гаратирует что будет создан новый объект. У java
         * есть собственный pool (heap) где хранятся все строки. Он смотрит если уже есть такое значение в String pool,
         * то в таком случае новая переменная уже ссылается на уже существующий объект(строку) из String Pool-аю
         *
         */
        String s = "String";


        /**
         *
         */
        var s1 = "Hello"; // java проверяет есть ли объект с таким значением в string pool-e, а его нет, будет создан
        var s2 = "Hello"; // java проверяет, объект с этим значение уже есть, новый не будет создан, это переменная будет ссылаться на существующий
        var s3 = "Hello"; // для этого объекта происходит тоже самое.
        var s4 = new String("Hello");// новый объект будет создан, и он никаого отношения к предыдущим не имеет

        /**
         * оператор == сравнивает ссылки, для сравнения значений нужно использовать метод equals(),
         * все проверки вернут true, так как и ссылочно и по значению они все ссылаются на один и тот же объект.
         */
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s2 == s3);
        System.out.println("Hello" == s3);
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        System.out.println(s2.equals(s3));
        System.out.println("Hello".equals(s3));

        /**
         * Так же есть метод equalsIgnoreCase, который тоже сравнивает содержимое, но игнорирует case
         */

        var str1 = "How Are You?";
        var str2 = "how are you?";
        str1.equalsIgnoreCase(str2);//true


        /**
         * основные методы String; ни один из них не изменяет оригинальную строку, то есть источник, они все возвращают
         * изменения в качестве результата.
         */
        s.length(); //длина
        s.charAt(1); // получить char из String по index
        s.indexOf('e'); //получить index по char
        s.startsWith("Hel"); // начинается ли с "Hel"
        s.startsWith("Hel", 4); // начинается ли с "Hel" начиная с 4 index
        s.endsWith("lo"); // заканчивается ли с "lo"
        s.substring(2); // вырезать все начиная с указанного index, и вернуть
        s.substring(2, 6); // вырезать все начиная с первого index по второй, и вернуть
        s.trim(); // убирает все пустые символы и пробелы по бокам, те что в середине не трогает
        s.replace('H', 'z'); // заменяет
        s.concat("4443"); // просто оператор +
        s.toUpperCase(); // все заглавными
        s.toLowerCase(); // все строчными
        s.contains("ello"); //имеется ли такой порядок строк


        var chars = new char[]{'3', 'c', 't'};
        var str = new String(chars);

    }
}
