package multithread.lesson7;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class CountDownLatchExample {

    /**
     * CountDownLatch – это синхронизатор, позволяющий любому количеству потоков ждать пока не завершится
     * определённое количество операций. В конструктор CountDownLatch нужно передавать количество
     * операций, которые должны завершится, чтобы потоки продолжили свою работу
     */

    static CountDownLatch countDownLatch = new CountDownLatch(3);

    public static void main(String[] args) throws InterruptedException {

        new Friend("Osman",countDownLatch );
        new Friend("Oleg",countDownLatch );
        new Friend("Ivan",countDownLatch );
        new Friend("Marsel",countDownLatch );
        new Friend("Nikita",countDownLatch );
        marketStaffIsPlace();
        everythingIsReady();
        openMarket();

    }

    private static void marketStaffIsPlace() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Market staff come to work ");
        countDownLatch.countDown(); // уменьшаем на единицу
        System.out.println("countDownLatch: " + countDownLatch.getCount());
    }

    private static void everythingIsReady() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Everything is ready");
        countDownLatch.countDown(); // уменьшаем на единицу
        System.out.println("countDownLatch: " + countDownLatch.getCount());
    }


    private static void openMarket() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Market is open");
        countDownLatch.countDown(); // уменьшаем на единицу
        System.out.println("countDownLatch: " + countDownLatch.getCount());
    }

}

class Friend extends Thread {

    private final CountDownLatch countDownLatch;
    private final String name;

    public Friend(String name, CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
        this.name = name;
        this.start();
    }

    @Override
    public void run() {

        try {
            /**
             * Будем ждать до тех пор, пока счетчик не станет равен нулю
             */
            countDownLatch.await();
            System.out.println(name + " приступил(а) к закупкам");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
