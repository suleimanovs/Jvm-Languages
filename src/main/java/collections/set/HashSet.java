package collections.set;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 * Created by Osman on 2:27 PM
 */
public class HashSet<T> implements MySet<T> {

    private static final int INITIAL_SIZE = 16;
    private static final double LOAD_FACTOR = 0.75;
    private int size = 0;
    private Object[] entries = new Object[INITIAL_SIZE];

    @Override
    public boolean contains(T car) {
        int position = getPosition(car, entries.length);
        Entry entry = (Entry) entries[position];
        if (entry == null) return false;
        while (entry != null) {
            if (entry.value.equals(car)) {
                return true;
            } else entry = entry.next;
        }
        return false;
    }

    @Override
    public boolean add(T car) {
        if (size >= (entries.length * LOAD_FACTOR)) {
            increaseSize();
        }
        if (add(car, entries)) {
            size++;
            return true;
        }
        return false;
    }

    private boolean add(T car, Object[] dst) {
        int position = getPosition(car, dst.length);
        if (dst[position] == null) {
            Entry entry = new Entry(car, null);
            dst[position] = entry;
            return true;
        } else {
            Entry existedElement = (Entry)dst[position];
            while (true) {
                if (car.equals(existedElement.value)) {
                    return false;
                } else if (existedElement.next == null) {
                    existedElement.next = new Entry(car, null);
                    return true;
                } else {
                    existedElement = existedElement.next;
                }
            }
        }
    }

    @Override
    public boolean remove(T car) {
        int position = getPosition(car, entries.length);
        Entry entry = (Entry) entries[position];
        if (entry == null) return false;
        Entry next = entry.next;
        if (entry.value.equals(car)) {
            entries[position] = next;
            size--;
            return true;
        } else {

            while (next != null) {
                if (next.value.equals(car)) {
                    entry.next = next.next;
                    size--;
                    return true;
                }
                if (next.next == null) {
                    return false;
                } else {
                    entry = next;
                    next = next.next;
                }
            }
        }
        return false;
    }

    @Override
    public void clear() {
        entries = new Object[INITIAL_SIZE];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;
            int columnIndex=0;
            Entry entry;
            @Override
            public boolean hasNext() {
                return index<size;
            }

            @Override
            public T next() {
                while(entry==null){
                    entry = (Entry)entries[columnIndex++];
                }

                T result = entry.value;
                index++;
                entry = entry.next;
                return result;

            }
        };
    }

    private int getPosition(T object, int arrayLength) {
        return Math.abs(object.hashCode() % arrayLength);
    }

    private void increaseSize() {

        Object[] newEntries = new Object[entries.length * 2];
        for (Object car : entries) {
            Entry element= (Entry) car;
            while (element!=null){
                add(element.value, newEntries);
                element= element.next;
            }

        }
        entries = newEntries;
    }

    class Entry {
        T value;
        Entry next;

        public Entry(T value, Entry next) {
            this.next = next;
            this.value = value;
        }
    }
}
