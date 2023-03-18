package multithread.lesson5;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.*;

/**
 * Created by Osman on 2:06 PM
 * Thread pool – это множество потоков, каждый из которых предназначен для выполнения той или иной задачи.
 * В Java с thread pool-ами удобнее всего работать посредством ExecutorService
 */
public class ExecutorServiceExample {

    public static void main(String[] args) throws InterruptedException {
        /**
         * Thread pool удобнее всего создавать, используя factory методы класса Executors:
         *
         * {@link Executors#newFixedThreadPool} - пул потоков фиксированной длины, при его созданий мы сами указываем,
         * сколько потоков будет создано.
         *
         * {@link Executors#newSingleThreadExecutor()} -пул из одного потока, все задачи переданные в него будут выполняться
         * последовательно, ожидая своей очереди на исполнение.
         *
         * {@link Executors#newCachedThreadPool()} - потоки будут создаваться по мере необходимости, если прилетит
         * новая задача, пока все потоки заняты, то будет создан ещё один поток.
         *
         */
        ExecutorService executorFixedThreadPool = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {

            final int index = i;

            /**
             * Метод execute передаёт наше задание (task) в thread pool, где оно выполняется одним из потоков.
             */
            //Runnable
            executorFixedThreadPool.execute(() -> {
                System.out.println("Start-" + index);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Finish-" + index + "\n");
            });
        }
        /**
         * Означает что как только все потоки выполнят свою работу, они должны завершиться.
         * По умолчанию потоки ждут нового сообщения. С этого момента в него больше нельзя передать новых задач.
         * После выполнения метода shutdown ExecutorService понимает, что новых заданий больше не будет и, выполнив
         * поступившие до этого задания, прекращает работу.
         */
        executorFixedThreadPool.shutdown();

        /**
         * Метод awaitTermination принуждает поток в котором он вызвался подождать до тех пор, пока не выполнится одно
         * из двух событий: либо ExecutorService прекратит свою работу, либо пройдёт время, указанное в параметре
         * метода awaitTermination
         */
        executorFixedThreadPool.awaitTermination(5,TimeUnit.SECONDS);


        /**
         * {@link Executors#newSingleThreadExecutor} - создает только один пул поток.
         * Делаем его потоком демоном, передавая в качестве аргумента ThreadFactory.
         * Тут мы сами вручную создаем поток, каждый раз когда мы вызываем метод execute, все Runnable прилетят в
         * метод newThread, и в этой функций мы сами обрабатываем поток.
         */
        ExecutorService executorService = Executors.newSingleThreadExecutor(new ThreadFactory() {
            @Override
            public Thread newThread(@NotNull Runnable runnable) {
                Thread thread = new Thread(runnable);
                thread.setDaemon(true);
                return thread;
            }
        });

        executorService.execute(() -> {
            try {
                while (true) {
                    System.out.print(".");
                    Thread.sleep(300);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });




    }
}
