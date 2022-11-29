package multithread.lesson4;


/**
 * простая демонстрация центра звонков, одновременно мы можем принять только один звонок, а все остальные должны
 * стоять в очереди
 * Та же демонстрация, но с использованием {@link java.util.concurrent.locks.Lock} и
 * {@link java.util.concurrent.locks.ReentrantLock} можно найти в файле {@link multithread.lesson8.LockAndReentrantLock}
 */
class CallCenter {

    /**
     * Монитор – это сущность/механизм, благодаря которому достигается корректная работа при синхронизации.
     * В Java у каждого класса и объекта есть привязанный к нему монитор.
     * Отличие синхронизированного метода от несинхронизированного в том, что синхронизированный метод может быть
     * вызван одновременно только одним потоком
     * <p>
     * Объект синхронизации(монитор) - Это объект или класс, по кострому происходит синхронизация потоков.
     * Если поток видит, что монитор занят, то будет ждать его освобождения, если монитор свободен, то поток
     * его занимает и монитор переходит в состояние "ЗАНЯТ".
     * В ролле такого объекта синхронизации(монитора) - может быть любой класс или объект.
     * А если сам метод помечен как {@synhronized} то в качестве монитора будет использован тот класс(объект),
     * в котором метод определен.
     */
    private final Object lock = new Object();

    void mobileCall() {
        synchronized (lock) {
            System.out.println("Mobile call starts");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Mobile call ends");
        }

    }


    void whatsappCall() {
        synchronized (lock) {
            System.out.println("Whatsapp call starts");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Whatsapp call ends");
        }
    }


    void skypeCall() {
        synchronized (lock) {
            System.out.println("Skype call starts");
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Skype call ends");
        }
    }

    public static void main(String[] args) {

        var callCenter = new CallCenter();

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
