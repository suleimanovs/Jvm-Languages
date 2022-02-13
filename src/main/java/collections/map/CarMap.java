package collections.map;

import java.util.List;
import java.util.Set;

/**
 * Created by Osman on 7:29 PM
 */
public interface CarMap<K,V> {

    void put(K key, V value);

    V get(K key);

    Set<K> keys();

    List<V> values();

    boolean remove(K key);

    int size();

    void clear();


}
