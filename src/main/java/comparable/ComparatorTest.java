package comparable;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Interface Comparator - используется для сравнения объектов, используя НЕ естественный порядок.
 * Interface Comparator используется в случаях когда у нас нет доступа к классу, что бы реализовать ь там Comparable
 * или изменить реализацию если она есть. Так в случаях когда мы хотим сравнить объекты по иному порядку.
 * Например, сделать Comparator который будет сравни ать объекты класса String не по алфавиту, а по их длине
 */
public class ComparatorTest {
    public static void main(String[] args) {

        var stringList = new ArrayList<String>();
        stringList.add("Almas");
        stringList.add("Ivan");
        stringList.add("Dior");
        stringList.add("Alexander");
        stringList.add("Ivy");
        stringList.add("Salman");

        System.out.println("before sorting by length: " + stringList);
        Collections.sort(stringList, new Comparator<String>() {
            /**
             * Тут сравниваются класс String по их длине, несмотря на то что у String уже есть реализация Comparable,
             * метод sort будет использовать наш Comparator. Таким образом нет не нужно каждый раз изменять реализацию
             * Comparable. Если требуется сравнить по НЕ естественному порядку, то достаточно создать разные реализаций
             * класса Comparator
             */
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) return 0;
                else if (o1.length() < o2.length()) return -1;
                else return 1;
                /**
                 * можно было бы сократить до такого:
                 * <pre>@code{
                 *   return Integer.compare(o1.length(), o2.length());
                 * }</pre>
                 */
            }
        });
        System.out.println("after sorting by length: " + stringList);


    }
}
