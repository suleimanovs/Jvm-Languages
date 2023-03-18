package iterable;


import collections.list.ArrayList;

import java.util.HashSet;
import java.util.Iterator;

public class IterableTest {

    public static void main(String[] args) {

        /**
         * Интерфейс Iterable позволяет перебирать коллекцию в цикле forEach. У этого интерфейса ест один метод iterator
         * который возвращает объект типа Iterator. Одним словом Iterable это прост обертка над Iterator
         */
        var list = new ArrayList<String>();
        var set = new HashSet<String>();

        System.out.println(list instanceof Iterable);
        System.out.println(set instanceof Iterable);

    }

}
