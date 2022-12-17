package multithread.lesson7;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Osman on 7:19 AM
 *
 * Методы {@link #add(Runnable)} и {@link #take()} синхронизированы по одному монитору.
 * То есть их нельзя вызвать одновременно.
 *
 * При вызове метода  {@link #take()} если очередь пуста, то у монитора вызывается wait(), это заставляет текущий
 * поток остановиться, а так же освобождает монитор. То есть поток, в котором был вызван метод {@link #take()} засыпает.
 * При вызове метода notify- поток просыпается. И работа потока начинается с того места где его приостановили.
 *
 * Различие метода notify и notifyAll:
 * - Метод notify пробуждает один первый попавший поток.
 * - Метод notifyAll пробуждает все потоки.
 */
public class BlockingQueue {

    private final Object monitor = new Object();
    private final Queue<Runnable> queue = new LinkedList<>();

    public void add(Runnable r) {
        synchronized (monitor) {
            queue.add(r);
            monitor.notify();
        }

    }

    public Runnable take() {
        synchronized (monitor) {
            try {
                while (queue.isEmpty()) {
                    monitor.wait();//останавливает поток, и высвобождает монитор.
                }
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            return queue.poll();
        }
    }


}

class Main {

    public static void main(String[] args) {
        BlockingQueue blockingQueue = new BlockingQueue();

        new Thread(() -> {
            while (true) new Thread(blockingQueue.take()).start();

        }).start();


        for (int i = 0; i < 10; i++) {
            final int index = i;
            blockingQueue.add(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("task ---- " + index);

            });
        }
    }
}
