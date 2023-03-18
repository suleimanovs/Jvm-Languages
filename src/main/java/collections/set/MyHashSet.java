package collections.set;

/**
 * Created by Osman on 12:10 PM
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * В основе HashSet лежить хэш - таблица
 */
public class MyHashSet<T> implements MySet<T> {


    private final Map<T, Object> map = new HashMap<>();
    private final Object object = new Object();


    @Override
    public boolean add(T car) {
        if (map.containsKey(car)) {
            return false;
        }
        map.put(car, object);
        return true;
    }

    @Override
    public boolean remove(T car) {
        Object removed = map.remove(car);
        return removed != null;
    }

    @Override
    public boolean contains(T car) {
        return map.containsKey(car);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Iterator<T> iterator() {
        return map.keySet().iterator();
    }


}
