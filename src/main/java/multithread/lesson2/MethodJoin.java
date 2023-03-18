package multithread.lesson2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by osmanboy on 1/28/2022
 *
 * Если мы хотим дождаться выполнения какого нибудь потока, то нужно вызвать метод {@link Thread#join()}
 * Метод join заставляет поток в котором мы его вызвали остановиться и дождаться завершения
 * того потока для которого он был вызван(если мы вызвали этот метод в главном потоке,
 * то главный поток будет остановиться и ждать завершения не главного потока.
 *
 * Метод join тоже выбрасывает ошибку {@link InterruptedException}, так как мы можем ждать поток который был остановлен
 * Если мы создали какой-то поток и запустили его, мы не можем знать когда именно он будет запущен. Ни когда
 * нельзя знать порядок в котором будут вызываться потоки.
 */
public class MethodJoin {

    public static void main(String[] args) {

        var list1 = new ArrayList<>();
        var list2 = new ArrayList<>();
        var list3 = new ArrayList<>();


        var thread1 = new Thread(() -> {
            for (int i = 0; i < 10000000; i++) list1.add(i);
            System.out.println(Thread.currentThread().getName()+" are finished his work");
        });

        var thread2 = new Thread(() -> {
            for (int i = 0; i < 10000000; i++) list2.add(i);
            System.out.println(Thread.currentThread().getName()+" are finished his work");
        });

        var thread3 = new Thread(() -> {
            for (int i = 0; i < 10000000; i++) list3.add(i);
            System.out.println(Thread.currentThread().getName()+" are finished his work");
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
        /**
         * Этот код не будет выполнен, так как главный поток ждет завершения других потоков
         */
        System.out.println(list1.size());
        System.out.println(list2.size());
        System.out.println(list3.size());
        System.out.println("Finish!");

        /**
         * {@link Thread#join(long)} - overload method, в параметрах мы указываем сколько максимально он может ждать
         * завершения. Если за это время поток не успеет завершить свою работу, то наш поток продолжить свою работу дальше
         *  если он не успеет завершиться, то главный поток завершит свою работу, то есть метод main
         */
        try {
            thread1.join(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("I continue my work");
    }
}
