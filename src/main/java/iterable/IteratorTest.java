package iterable;

import collections.list.ArrayList;

public class IteratorTest {

    public static void main(String[] args) {

        /**
         * Iterator реализован во всех коллекция в методе iterator интерфейса Iterable. Этот Итератор идет последовательно
         * Метод hasNext() проверяет есть ли элемент.
         * Метол next() возвращает элемент.
         * Метод remove() удаляет текущий элемент в списке. Если до него не вызвать метод next(), будет выброшено ошибка
         * Метод forEachRemaining() выполняет Consumer над каждым элементом в списке
         */

        var list = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }

        var iterator = list.iterator();

        while (iterator.hasNext()) {
            if (iterator.next() % 2 == 0) {
                iterator.remove();
            }
        }

        System.out.println(list);


        var list2 = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++) {
            list2.add(i);
        }
        var iterator2 = list2.iterator();

        iterator2.forEachRemaining((integer) -> {
            System.out.print(integer * 2);
        });
        System.out.println(list2);


    }

}


