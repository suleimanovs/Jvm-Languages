package multithread.lesson10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by Osman on 11:30 AM
 */
public class LockFilePathForThread {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        /**
         * {@link Semaphore} - управляет доступом к общему ресурсу с помощью счетчика.
         * Если значение счетчика больше нуля - доступ разрешен, если равно нулю, то в доступе будет отказано.
         * Этот класс предназначен для ограничения доступа к какому-то ресурсу,
         * в конструктор мы передаем количество допустимых потоков которые могут одновременно
         * обращаться к какой-то секций. Чем-то он похож на {@link java.util.concurrent.CountDownLatch}
         * У него нужно вызвать метод {@link Semaphore#acquire()} что бы он уменшил значение счетчика на единицу.
         */
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " started to work");

                try {
                    Thread.sleep(500);
                    semaphore.acquire();
                    workWithFileSystem();
                } catch (InterruptedException iE) {
                    iE.printStackTrace();
                } finally {
                    semaphore.release();
                }
                System.out.println(Thread.currentThread().getName() + " finished to work");

            });
        }
        executorService.shutdown();

    }

    private static void workWithFileSystem() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " started to work with file system");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        System.out.println(name + " finished to work with file system");

    }
}
