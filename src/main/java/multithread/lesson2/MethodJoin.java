package multithread.lesson2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by osmanboy on 1/28/2022
 *
 * Если мы хотим дождаться выполнения какого нибудь потока то нужно вызвать метод {@link Thread#join()}
 * Метод join заставляет поток в котором мы его вызвали остановиться и дождаться завершения
 * того потока для которого он был вызван(если мы вызвали этот метод в главном потоке,
 * то главный поток будет останавиться и ждать  завершения не главного потока.
 *
 * Если мы создали какой-то поток и запустили его, мы не можем знать когда именно он будет запущен. Ни когда
 * нельзя знать порядок в котором будут вызываться потоки.
 */
public class MethodJoin {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();


        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) list1.add(i);

        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) list2.add(i);

        });

        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) list3.add(i);

        });

        thread1.start(); // Это не значит что потоки будут запущены именно в таком порядке и выполняться.
        thread2.start(); // Это не значит что потоки будут запущены именно в таком порядке и выполняться.
        thread3.start(); // Это не значит что потоки будут запущены именно в таком порядке и выполняться.

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(list1.size());
        System.out.println(list2.size());
        System.out.println(list3.size());

    }
}
