package multithread.lesson5;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceExample {

    public static void main(String[] args) {

        /**
         * ScheduledExecutorService мы используем тогда, когда хотим установить расписание на запуск потоков из пула.
         * Данный pool создаётся, используя factory метод класса
         * {@link Executors#newScheduledThreadPool(int)}
         */
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

        /**
         * запланируем старт этой задачи через 3 секунды.(чем-то похож на Handler)
         */
        scheduledExecutorService.schedule(new RunnableForSch(), 3, TimeUnit.SECONDS);

        /**
         * Запланируем старт этой задачи через 4 секунды. И это задача будет выполниться
         * периодически каждые 2 секунды. Если сама задача выполняется больше 2 секунд. То period время истекает за это
         * время. И последующая задача начинается моментально
         * Если вызвать метод shutDown() сразу же после этого, то последующие периодические задачи не будут
         * выполнены. Так как shutDown() говорить что больше никоих задач не ждет(не считая уже запущенных)
         */
        scheduledExecutorService.scheduleAtFixedRate(new RunnableForSch(), 4,2, TimeUnit.SECONDS);


        /**
         * Запланируем старт этой задачи через 4 секунды. И это задача будет выполниться
         * периодически каждые 2 секунды. Если сама задача выполняется больше 2 секунд. То period время не истекает за это
         * время. Последующая задача все равно начинается через 2 секунд
         * Если вызвать метод shutDown() сразу же после этого, то последующие периодические задачи не будут
         * выполнены. Так как shutDown() говорить что больше никоих задач не ждет(не считая уже запущенных)
         */
        scheduledExecutorService.scheduleWithFixedDelay(new RunnableForSch(), 4,2, TimeUnit.SECONDS);



    }

    static class RunnableForSch implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread()+" starts his work");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread()+" ends his work");

        }
    }

}
