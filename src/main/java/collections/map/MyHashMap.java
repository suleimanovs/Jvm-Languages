package collections.map;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Osman on 6:47 PM
 */
public class MyHashMap<K, V> implements CarMap<K, V> {
    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    private Object[] array = new Object[INITIAL_CAPACITY];
    private int size = 0;


    @Override
    public void put(K key, V value) {
        if (size >= (LOAD_FACTOR * array.length)) {
            increaseArray();
        }
        boolean isPut = put(key, value, array);
        if (isPut) {
            size++;
        }

    }

    private void increaseArray() {
        Object[] newArray = new Object[array.length * 2];
        for (Object item : array) {
            Entry entry = (Entry) item;
            while (entry != null) {
                put(entry.key, entry.value, newArray);
                entry = entry.next;
            }
        }
        array = newArray;

    }

    private boolean put(K key, V value, Object[] src) {
        int position = getPosition(key, src.length);
        if (src[position] == null) {
            src[position] = new Entry(key, value, null);
            return true;
        } else {
            Entry entry = (Entry) src[position];
            while (true) {
                if (entry.key.equals(key)) {
                    entry.value = value;
                    return false;
                }
                if (entry.next == null) {
                    entry.next = new Entry(key, value, null);
                    return true;
                }
                entry = entry.next;
            }
        }
    }

    private int getPosition(K key, int arrayLength) {
        return Math.abs(key.hashCode() % arrayLength);
    }

    @Override
    public V get(K key) {
        Entry entry = (Entry) array[getPosition(key, array.length)];
        while (entry != null) {
            if (entry.key.equals(key)) return entry.value;

            entry = entry.next;
        }
        return null;
    }

    @Override
    public Set<K> keys() {
        Set<K> keys = new HashSet<K>();
        for (Object item : array) {
            Entry entry = (Entry) item;
            while (entry != null) {
                keys.add(entry.key);
                entry = entry.next;
            }
        }
        return keys;
    }

    @Override
    public List<V> values() {
        List<V> values = new ArrayList<>();
        for (Object item : array) {
            Entry entry = (Entry) item;
            while (entry != null) {
                values.add(entry.value);
                entry = entry.next;
            }
        }
        return values;
    }

    @Override
    public boolean remove(K key) {
        int position = getPosition(key, array.length);
        Entry entry = (Entry) array[position];
        if (entry != null && entry.key.equals(key)) {
            array[position]=entry.next;
            size--;
            return true;
        }

            while (entry!=null) {
                Entry nextEntry = entry.next;
                if (nextEntry == null) {
                    return false;
                }
                if (nextEntry.key.equals(key)) {
                    entry.next = nextEntry.next;
                    size--;
                    return true;
                }

                entry = entry.next;
            }
            return false;

    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        array = new Object[INITIAL_CAPACITY];
        size = 0;
    }


    class Entry {
        final K key;
        V value;
        Entry next;

        Entry(K key, V value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

    }
}
