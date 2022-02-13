package multithread.lesson4;

/**
 * RaceCondition(Состояние гонки) - это когда два потока одновременно управляют одной программной сущностью.
 * <p>
 * Отличие синхронизированного метода от несинхронизированного в том, что синхронизированный метод может быть
 * вызван одновременно только одним потоком
 * <p>
 * Обьект синхронизации(монитор) - Это обьект или класс , по котрому происходит синхронизация потоков.
 * Если поток видит, что монитор занят, то будет ждать его освобождения , если монитор свободен, то поток
 * его занимает и монитор переходит в состояние "ЗАНЯТ".
 * В ролли такого обьекта синхронизации(монитора) -  может быть любой класс или обьект.
 * А если сам метод помечен как {@synhronized} то в качестве монитора будет использован тот класс(обьект),
 * в котором метод определен.
 */
public class RaceCondition {

    /**
     * ключевое слово volatile - запрещает кэшировать переменную (сохранять значение в локальную память потока)
     * и говорит о том, что ее значение нужно брать из основной памяти.
     * Когда к переменной идёт обращение из разных потоков стоить сделать ее volatile
     */
    private volatile int number;

    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread decrementThread = new Thread(() -> {
            for (int i = 0; i < 10000; i++) counter.dec();
        });


        Thread incrementThread = new Thread(() -> {
            for (int i = 0; i < 10000; i++) counter.increment();
        });


        decrementThread.start();
        incrementThread.start();

        try {
            decrementThread.join();
            incrementThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(counter.getValue());
    }

}
