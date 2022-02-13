package multithread.lesson5;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.*;

/**
 * Created by Osman on 2:06 PM
 */
public class ExecutorServiceExample {

    public static void main(String[] args) {
        /**
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
         */
        executorFixedThreadPool.shutdown();


        /**
         * {@link Executors#newSingleThreadExecutor} - создает только один пул поток.
         * Делаем его потоком демоном, передавая в качестве аргумента ThreadFactory .
         * Тут мы сами  вручную создаем поток, каждый раз когда мы вызывем метод execute, все Runnable прилетят в
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


        /**
         * метод {@link ExecutorService#submit(Callable)} делает тоже самое что и
         * {@link ExecutorService#execute(Runnable)}, отличие в том что он в качестве параметра
         * пртнтмает не реализацию Runnable, a Callable- этот интерфейс может что-то вернуть, для класса
         * Future<T>
         */
        Future<String> futureName = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(5000);
                return "Osman Boy";
            }

        });

        try {
            /**
             * Метод {@link Future#get()} делает почти тоже самое что и метод join().
             * тоже останавливает поток, и дождеться завершения другова потока
             */
            String name = futureName.get();
            System.out.println(name);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


    }
}
