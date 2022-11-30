package collections.list;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by Osman on 10:06
 */


/**
 * В основе ArrayList лежит массив, ArrayList реализует интерфейс List
 * <p>
 * <p>
 * Алгоритмическая сложность операций в коллекции ArrayList:
 * + @get - Получение элемента по индексу - O(1)
 * + @add(index) - Вставка элемента в конец списка - O(1)
 * - @remove - Удаление элемента - O(N)
 * - @add(element,index) - Вставка элемента в конец списка - O(N)
 * - Внутренний размер массива не изменяется при удалении элементов, может возникнуть утечка памяти
 * <p>
 * подробнее см. [AlgorithmsInfo]
 */
public class MyArrayList<E> implements MyList<E> {

    private Object[] array = new Object[10];
    private int size = 0;

    @Override
    public E get(int index) {
        checkIndex(index);
        return (E) array[index];
    }

    @Override
    public boolean add(E element) {
        increaseArray();
        array[size] = element;
        size++;
        return true;
    }

    @Override
    public boolean add(E element, int index) {
        increaseArray();
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        size++;
        return true;
    }

    @Override
    public boolean remove(E element) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                return removeAt(i);
            }
        }
        return false;
    }

    @Override
    public boolean contains(E element) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        checkIndex(index);
        System.arraycopy(array, index + 1, array, index, size - 1 - index);
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        array = new Object[10];
        size = 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public E next() {
                return (E) array[index++];
            }
        };
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void increaseArray() {
        if (size >= array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
    }
}
