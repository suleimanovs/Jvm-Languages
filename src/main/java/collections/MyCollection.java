package collections;

/**
 * Created by Osman on 11:57 AM
 */
public interface MyCollection<T> extends Iterable<T> {
    boolean add(T car);

    boolean remove(T car);

    int size();

    void clear();

    boolean contains(T car);
}
