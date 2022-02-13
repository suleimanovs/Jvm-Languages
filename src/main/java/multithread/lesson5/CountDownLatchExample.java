package multithread.lesson5;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Osman on 1:49 PM
 */
public class CountDownLatchExample {

    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(10);


        for (int i = 0; i < 10; i++) {

            final int index = i;

            /**
             * Создание потока тяжёлая операция, и занимает какое-то время. Создавать огромное количество потоков
             * нерационально. В таких случаях когда требуется выполнять много разных задач в отдельных потоках,
             * рационально использовать {@link java.util.concurrent.ExecutorService}.
             * Пример использования см : {@link ExecutorServiceExample}
             */
            new Thread(() -> {
                System.out.println("Start-" + index);
                try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
                System.out.println("Finish-" + index);
                countDownLatch.countDown();
            }).start();
        }

        try {
            countDownLatch.await();//делает тоже самое что и join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Все Потоки Завершены!");

    }
}
