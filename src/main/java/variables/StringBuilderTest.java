package variables;

public class StringBuilderTest {
    public static void main(String[] args) {

        /**
         * StringBuilder - этот класс в отличие от String является изменяемым, то есть под капотом у него не final массив,
         * и все методы этого класса позволяет нам изменят внутренний массив. Каждый раз когда мы хотим изменить
         * содержимое String, на самом деле создается новый объект String. Это очень ресурс затратно.
         * У StringBuilder много методов такие же как у String.
         */

        var stringBuilder1 = new StringBuilder(); // начальная capacity 16; создает массив с размером 16
        var stringBuilder2 = new StringBuilder(24); // мы сами задаем capacity
        var stringBuilder3 = new StringBuilder("StringBuilder"); // длина строки + 16, и будет начальной capacity

        System.out.println(stringBuilder1.capacity()); //16
        System.out.println(stringBuilder2.capacity()); //24
        System.out.println(stringBuilder3.capacity()); //29


        stringBuilder3.subSequence(1,3); // такой же как substring
        stringBuilder3.append(12); // добавляет в конец
        stringBuilder3.append(12F); // добавляет в конец
        stringBuilder3.append(12L);// добавляет в конец
        stringBuilder3.append('f');// добавляет в конец
        stringBuilder3.append(12D);// добавляет в конец
        stringBuilder3.append("salam aleykum");// добавляет в конец
        stringBuilder3.insert(1,"dodo"); // вставляет после insert
        stringBuilder3.deleteCharAt(5); // удаляет по индексу
        stringBuilder3.delete(1,4); // удаляет по интервалу
        stringBuilder3.reverse();
        stringBuilder3.replace(1,4,"irfifk");


        /**
         * StringBuffer - это аналог StringBuilder, но используется в многопоточности, так как его методы потока безопасные
         */
        var stringBuffer = new StringBuffer();



    }
}
