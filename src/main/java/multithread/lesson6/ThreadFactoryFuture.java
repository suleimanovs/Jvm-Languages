package multithread.lesson6;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.util.concurrent.*;

/**
 * Created by Osman on 2:15 PM
 */
public class ThreadFactoryFuture {

    public static void main(String[] args) {
        /**
         * Тут мы сами вручную создаем поток, каждый раз когда мы вызывем метод execute, все Runnable прилетят в
         * метод newThread, и в этой функций мы сами обрабатываем поток.
         */
        ExecutorService executorService = Executors.newFixedThreadPool(2, new ThreadFactory() {
            @Override
            public Thread newThread(@NotNull Runnable r) {
                Thread thread = new Thread(r);
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
         * Возвращает данные из потока. Для этого мы должны у ExecutorService вызвать метод submit.
         * И в качестве аргумента передать не "Runnable" а "Callable". Потому что отличие метода {@link Callble#call}
         * от {@link Runnable#run}  в том что он что-то возвращает.
         */
        Future<String> futureName = executorService.submit(new Callable<String>() {

            @Override
            public String call() throws Exception {
                Thread.sleep(5000);
                return "Osman Boy";
            }

        });

        Future<Integer> futureAge = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(2000);
                return 19;
            }
        });

        /**
         * Для получения результата нужно вызвать метод get.
         * Этот метод нужно оборачивать в try|catch.
         */
        try {
            String name = futureName.get();
            Integer age = futureAge.get();
            System.out.println("\nName: " + name + " Age: " + age);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}
