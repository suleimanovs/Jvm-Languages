package iterable;

import collections.list.ArrayList;

public class ListIteratorTest {

    public static void main(String[] args) {

        /**
         * ListIterator наследуется от Iterator. Отличие в том что он поддерживает как и последовательную итерацию, так
         * и итерацию в обратную сторону.
         * Метод hasNext() проверяет есть ли следующий элемент.
         * Метод hasPrevious() проверяет есть ли предыдущий элемент.
         * Метол next() возвращает следующий элемент.
         * Метол previous() возвращает предыдущий элемент.
         * Метод remove() удаляет текущий элемент в итерациях. Если до него не вызвать метод next(), previous() будет
         * выброшено ошибка
         * Метод forEachRemaining() выполняет Consumer над каждым элементом в итераций
         *
         * Метод add() добавляет элемент в конец списка
         *
         * Метод set() - Replaces the last element returned by next or previous with the specified element (optional operation)
         */

        var list = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }

        var iterator = list.listIterator();

        while (iterator.hasNext()) {
            System.out.println("index: " + iterator.nextIndex() + " value: " + iterator.next());
        }

        while (iterator.hasPrevious()) {
            System.out.println("index: " + iterator.previousIndex() + " value: " + iterator.previous());

        }

        var iterator2 = list.listIterator();
        while (iterator2.hasNext()) {
            var next = iterator2.next();
            iterator2.set(next * 2); //заменяет элемент возращенный от next() или previous()
        }

        System.out.println(list);

    }

}


