package comparable;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class ComparableTest {

    public static void main(String[] args) {
        var osman = new Programmer(124, "Osman", "Java", "Kotlin");
        var ivan = new Programmer(64, "Osman", "Python", "C++", "C#");
        var max = new Programmer(78, "Maxim", "Go", "Ruby", "Javascript");

        var programmerList = new ArrayList<Programmer>();
        programmerList.add(osman);
        programmerList.add(ivan);
        programmerList.add(max);


        System.out.println("before sorting: " + programmerList);
        /**
         * этот метод работает только с Comparable объектами.
         */
        Collections.sort(programmerList);
        System.out.println("after sorting: " + programmerList);

    }

}

/**
 * Interface Comparable - используется для сравнения объектов, используя естественный порядок.
 * Такие коллекций как TreeSet и TreeMap не могут работать с теми объектами которые не реализуют данный интерфейс
 * или не используют Interface Comparable в конструкторе.
 */
class Programmer implements Comparable<Programmer> {

    int id;
    String name;
    String[] languages;


    public Programmer(int id, String name, String... languages) {
        this.id = id;
        this.name = name;
        this.languages = languages;
    }

    @Override
    public String toString() {
        return "Programmer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", languages=" + Arrays.toString(languages) +
                '}';
    }

    @Override
    public int compareTo(@NotNull Programmer o) {
        /**
         * Тут мы сами описивывем то, как и чем должны сравнивать объекты, можем и по name, languages и т.д
         * в данном случае мы сравниаем объекты по их id
         */
        if (this.id == o.id) return 0;
        else if (this.id < o.id) return -1;
        else return 1;

        /**
         * более короткий вариант в случае int.
         * Если в результате данного выражения получиться 0, то значит наши объекты равны.
         * Если -1 то озночает что текущий объект меньше объекта из параметра
         * Если 1 или любое положитнльное число, то озночает что текущий объект меньше объекта из параметра
         * <pre>@code{
         *  return this.id-o.id;
         * }
         * </pre>
         *
         * или же использовать уже готовый метод
         *
         * <pre>@code{
         *  return Integer.compare(this.id, o.id);
         * }
         * </pre>
         */

    }
}
