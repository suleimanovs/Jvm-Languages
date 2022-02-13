package collections.queue;

import collections.CarCollection;

/**
 * Created by Osman on 7:09 PM
 */
public interface CarQueue<T> extends CarCollection<T> {

    boolean add(T car);

    T peek();

    T pool();
}


