package multithread;

import java.util.concurrent.*;

/**
 * Created by Osman on 12:45 PM
 */
public class HomeWork {

    private static final int CARS_TUNNEL_CONST = 3;
    private static final int CARS_COUNT = 10;
    private static final Semaphore semaphore = new Semaphore(CARS_TUNNEL_CONST);
    private static final ExecutorService executorService = Executors.newCachedThreadPool();
    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(CARS_COUNT);
    private static final CountDownLatch countDownLatch = new CountDownLatch(CARS_COUNT);
    private static int winnerIndex = -1;
    private static final Object monitor = new Object();

    public static void main(String[] args) {

        ConcurrentHashMap<Integer, Long> result = new ConcurrentHashMap<>();


        for (int i = 0; i < 10; i++) {
            final int index = i;
            executorService.execute(() -> {
                prepare(index);
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException interruptedException) {
                    interruptedException.printStackTrace();
                }
                long before = System.currentTimeMillis();
                roadFirst(index);
                tunnel(index);
                roadSecond(index);
                synchronized (monitor) {
                    if (winnerIndex == -1) {
                        winnerIndex = index;
                    }
                }
                long after = System.currentTimeMillis();

                result.put(index, (after - before));
                countDownLatch.countDown();

            });
        }


        executorService.shutdown();

        try {
            countDownLatch.await();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        System.out.println("Winner " + winnerIndex + " score " + result.get(winnerIndex));

        for (int item : result.keySet()) {
            System.out.println(item + " " + result.get(item));
        }


    }


    public static void sleepRandom() {
        long startTime = (long) (Math.random() * 5000 + 1000);
        try {
            Thread.sleep(startTime);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }

    }

    public static void prepare(int index) {
        System.out.println(index + " started  preparing");
        sleepRandom();
        System.out.println(index + " finished  preparing");

    }


    public static void roadFirst(int index) {
        System.out.println(index + " started roadFirst");
        sleepRandom();
        System.out.println(index + " finished roadFirst");
    }

    public static void roadSecond(int index) {
        System.out.println(index + " started roadSecond");
        sleepRandom();
        System.out.println(index + " finished roadSecond");
    }

    public static void tunnel(int index) {
        try {
            semaphore.acquire();
            System.out.println(index + " started tunnel");
            sleepRandom();
            System.out.println(index + " finished tunnel");
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        } finally {
            semaphore.release();
        }

    }

}
