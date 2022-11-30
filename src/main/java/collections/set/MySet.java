package collections.set;

import collections.MyCollection;

/**
 * Created by Osman on 11:50 AM
 */
public interface MySet<T> extends MyCollection<T> {

    boolean contains(T car);

    boolean add(T car);

    boolean remove(T car);

    void clear();

    int size();

}
