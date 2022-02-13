package collections.set;

import collections.CarCollection;

/**
 * Created by Osman on 11:50 AM
 */
public interface CarSet<T> extends CarCollection<T> {

    boolean contains(T car);

    boolean add(T car);

    boolean remove(T car);

    void clear();

    int size();

}
