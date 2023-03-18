package multithread.lesson4;

/**
 * Для извещения потоком других потоков о своих действиях часто используются следующие методы:
 * wait - освобождает монитор и переводит вызывающий поток в состояние ожидания до тех пор, пока другой
 * поток не вызовет метод notify();
 * notify – НЕ освобождает монитор, но будит поток, у которого ранее был вызван метод wait();
 * notifyAll – НЕ освобождает монитор, но будит все потоки, у которых ранее был вызван метод wait()
 */
public class WaitAndNotify {

    public static void main(String[] args) {
        var market = new Market();
        var producer = new Producer(market);
        var consumer = new Consumer(market);

        var producerThread = new Thread(producer);
        var consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();

    }

}


class Market {

    private int breadCount = 0;

    public synchronized void getBread() {

        /**
         * Причина по которой мы тут пользуемся циклом, а не if заключается в том, что как
         * было сказано в документациях, поток может в очен редких случаях проснуться и без вызова метода notify
         */
        while (breadCount < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        breadCount--;
        System.out.println("Потребитель купил один хлеб");
        System.out.println("количество хлеба в магазине: " + breadCount);
    }

    public synchronized void putBread() {

        while (breadCount >= 5) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        breadCount++;
        System.out.println("Производитель добавил на витрину 1 хлеб");
        System.out.println("количество хлеба в магазине: " + breadCount);
        notify();
    }

}

class Producer implements Runnable {

    Market market;

    public Producer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.putBread();
        }
    }
}

class Consumer implements Runnable {

    Market market;

    public Consumer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.getBread();
        }
    }
}