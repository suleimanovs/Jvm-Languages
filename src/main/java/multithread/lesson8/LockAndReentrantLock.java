package multithread.lesson8;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Цель {@link java.util.concurrent.locks.ReentrantLock} и @synchronized lock один и тот же. У synchronized lock
 * есть одно преимущества, нам не нужно забиться о том что бы закрыть lock, или открыть
 */
public class LockAndReentrantLock {

    private final Lock lock = new ReentrantLock();

    void mobileCall() {
        lock.lock();
        System.out.println("Mobile call starts");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        System.out.println("Mobile call ends");

    }


    void whatsappCall() {
        lock.lock();
            System.out.println("Whatsapp call starts");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                lock.unlock();
            }
            System.out.println("Whatsapp call ends");

    }


    void skypeCall() {
        lock.lock();
            System.out.println("Skype call starts");
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                lock.unlock();
            }
            System.out.println("Skype call ends");

    }

    public static void main(String[] args) {

        var callCenter = new LockAndReentrantLock();

        /**
         * Пока один метод работает с одним потоком, другие методы не могут работать с остальными потоками.
         * Потому что все методы синхронизированы по одному монитору
         */
        var thread1 = new Thread(callCenter::mobileCall);
        var thread2 = new Thread(callCenter::whatsappCall);
        var thread3 = new Thread(callCenter::skypeCall);

        thread1.start();
        thread2.start();
        thread3.start();


    }
}
