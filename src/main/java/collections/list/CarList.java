package collections.list;

import collections.CarCollection;

/**
 * Created by Osman on 7:23 AM
 */
public interface CarList<T> extends CarCollection<T> {

    boolean contains(T car);

    T get(int index);

    boolean add(T car);

    boolean add(T car, int index);

    boolean remove(T car);

    boolean removeAt(int index);

    int size();

    void clear();
}
