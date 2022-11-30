package multithread.collection.synchronised;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class SynchronizedCollection {

    public static void main(String[] args) {
        /**
         * Synchronized collections
         * Получаются из традиционных коллекций благодаря их обёртыванию. Сравнительно с Concurrent коллегиями, являются более
         * медленными. Так как везде ставятся lock-и
         */


        var synchronizedList = Collections.synchronizedList(new ArrayList<>());
        var synchronizedSet = Collections.synchronizedSet(new HashSet<>());
        var synchronizedMap = Collections.synchronizedMap(new HashMap<>());
    }

}
