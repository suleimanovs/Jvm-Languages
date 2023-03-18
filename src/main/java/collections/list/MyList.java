package collections.list;

import collections.MyCollection;

/**
 * Created by Osman on 7:23 AM
 */
public interface MyList<T> extends MyCollection<T> {

    boolean contains(T element);

    T get(int index);

    boolean add(T element);

    boolean add(T element, int index);

    boolean remove(T element);

    boolean removeAt(int index);

    int size();

    void clear();
}
