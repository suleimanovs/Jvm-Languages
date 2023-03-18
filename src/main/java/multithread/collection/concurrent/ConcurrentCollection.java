package multithread.collection.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentCollection {

    public static void main(String[] args) {

        /**
         * Concurrent collections
         * Изначально созданы для работы с многопоточностью.
         */


        /**
         * ConcurrentHashMap имплементируют интерфейс
         * ConcurrentMap, который в свою очередь происходит от интерфейса Map.
         * В ConcurrentHashMap любое количество потоков может читать элементы не блокируя его.
         * В ConcurrentHashMap, благодаря его сегментированию, при изменении какого-либо элемента блокируется
         * только bucket, в котором он находится.
         * В ConcurrentHashMap ни key, ни value не могут быть null.
         */
        var concurrentMap = new ConcurrentHashMap<String,String>();


        /**
         * CopyOnWriteArrayList имплементирует интерфейс List.
         * CopyOnWriteArrayList следует использовать тогда, когда вам нужно добиться потокобезопасности, у вас
         * небольшое количество операций по изменению элементов и большое количество по их чтению.
         * В CopyOnWriteArrayList при каждой операции по изменению элементов создаётся копия этого листа
         */

        var copyOnWriteArrayList = new CopyOnWriteArrayList<String>();


        /**
         * ArrayBlockingQueue – потокобезопасная очередь с ограниченным размером (capacity restricted)
         * Обычно один или несколько потоков добавляют элементы в конец очереди, а другой или другие потоки
         * забирают элементы из начала очереди.
         */

        var blockingQueue= new ArrayBlockingQueue<String>(3);

    }

}
