package multithread.lesson5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by osmanboy on 1/28/2022
 */
public class HomeWork {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CountDownLatch countDownLatch = new CountDownLatch(3);
        long start = System.currentTimeMillis();
        executorService.execute(() -> {
            int sum = 0;
            for (int i = 0; i < 1_000_000; i++) {
                if (i % 2 == 0) sum += i;
            }
            System.out.println("Task1: " + sum);
            countDownLatch.countDown();
        });


        executorService.execute(() -> {
            long sum = 0;
            for (int i = 0; i < 1_000_000; i++) {
                if (i % 7 == 0) sum += i;
            }
            System.out.println("Task2: " + sum);

            countDownLatch.countDown();
        });


        executorService.execute(() -> {
            List<Integer> list = new ArrayList<Integer>();
            int sum = 0;
            for (int i = 0; i < 1_000; i++) {
                list.add((int) (Math.random() * i));
            }
            for (Integer i : list) {
                if (i % 2 == 0) sum += i;
            }
            System.out.println("Task3: " + sum);
            countDownLatch.countDown();
        });


        try {
            executorService.shutdown();
            countDownLatch.await();
            System.out.println("time: "+(System.currentTimeMillis() - start));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
