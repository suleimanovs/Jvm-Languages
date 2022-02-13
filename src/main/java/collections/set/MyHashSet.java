package collections.set;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Osman on 14:42
 */
public class MyHashSet<T> implements CarSet<T> {

    Object object = new Object();
    Map<T, Object> collection = new HashMap<>();


    @Override
    public boolean contains(T car) {

        return collection.containsKey(car);
    }

    @Override
    public boolean add(T car) {
        return collection.put(car, object) == null;

    }

    @Override
    public boolean remove(T car) {
        return collection.remove(car) == object;
    }

    @Override
    public void clear() {
        collection.clear();
    }

    @Override
    public int size() {
        return collection.size();
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return collection.keySet().iterator();
    }


}
