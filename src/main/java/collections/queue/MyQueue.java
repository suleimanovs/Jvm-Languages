package collections.queue;

import collections.MyCollection;

/**
 * Created by Osman on 7:09 PM
 */
public interface MyQueue<T> extends MyCollection<T> {

    boolean add(T car);

    T peek();

    T pool();
}


