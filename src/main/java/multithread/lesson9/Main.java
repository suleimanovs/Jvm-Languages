package multithread.lesson9;

import java.util.*;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Osman on 19:33
 */

class SynchronizedCollection {
    private static final Object monitor = new Object();

    public void withoutSynchronizedCollection() {
        /**
         * Без синхронизаций в коллекциях произойдут состояние гонки, и не все элементы будут добавлены,
         * для решения этого, можно как вариант создать обьект синхронизаций(монитор) - {@link #monitor}
         * и синхронизировать два потока одним монитором, и тогда всё будет норм.
         * Тут мы делаем синхронизацию в ручную.
         *
         * Но есть и более продвинутый вариант решения: {@link #withSynchronizedCollection()}
         */
        List<Integer> numbersList = new ArrayList<>();
        CountDownLatch countDownLatch = new CountDownLatch(2);

        new Thread(() -> {
            synchronized (monitor) {
                try {
                    for (int i = 0; i < 100; i++) {
                        Thread.sleep(100);
                        numbersList.add(i);
                    }
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                countDownLatch.countDown();
            }
        }).start();


        new Thread(() -> {
            synchronized (monitor) {
                try {
                    for (int i = 0; i < 100; i++) {
                        Thread.sleep(100);
                        numbersList.add(i);
                    }
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                countDownLatch.countDown();
            }
        }).start();

        try { countDownLatch.await();}
        catch (InterruptedException interruptedException) {interruptedException.printStackTrace();}
        System.out.println(numbersList.size());
        for (int num : numbersList) {
            System.out.println(num);
        }
    }


    public void withSynchronizedCollection() {

        /**
         * Если с одной коллекцией нужно работать из разных потоков, то во избежание ошибок
         * из-за состояния гонки нужно, что бы она была синхронизирована.
         * Данный способ синхронизаций медленный, так как все методы коллекций будут синхронизированы
         * одним монитором, то есть вызвать методы одновременно не получиться.
         * ArrayList - {@link Collections#synchronizedList(List)} )
         * ArraySet - {@link Collections#synchronizedSet(Set)} )
         * Map - {@link Collections#synchronizedMap(Map)} )
         *
         * Но также есть другой способ синхронизации коллекций:
         * ArrayList - {@link java.util.concurrent.CopyOnWriteArrayList)
         * ArraySet - {@link java.util.concurrent.CopyOnWriteArraySet)
         * Map(более эффективен) - {@link java.util.concurrent.ConcurrentHashMap)
         * при записи она копирует старую коллекцую и подменяет ее на новый, это позволяет
         * одновренно выызвать методы,записать и удалить и т,д
         */
        List<Integer> numbersList = Collections.synchronizedList(new ArrayList<>());
        CountDownLatch countDownLatch = new CountDownLatch(2);

        new Thread(() -> {
            try {
                for (int i = 0; i < 100; i++) {
                    Thread.sleep(100);
                    numbersList.add(i);
                }
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            countDownLatch.countDown();
        }).start();


        new Thread(() -> {
            try {
                for (int i = 0; i < 100; i++) {
                    Thread.sleep(100);
                    numbersList.add(i);
                }
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            countDownLatch.countDown();
        }).start();

        try {
            countDownLatch.await();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        System.out.println(numbersList.size());

    }

}

public class Main {


    public static void main(String[] args) {
        SynchronizedCollection synchronizedCollection = new SynchronizedCollection();
        synchronizedCollection.withoutSynchronizedCollection();

    }
}
