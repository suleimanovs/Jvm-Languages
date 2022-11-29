package multithread.lesson4;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * RaceCondition(Состояние гонки) - это когда два потока одновременно управляют одной программной сущностью.
 * Data race – это проблема, которая может возникнуть когда два и более потока обращаются к одной и той же
 * переменной и как минимум 1 поток её изменяет
 */
public class RaceCondition {

    /**
     * Ключевое слово volatile - запрещает кэшировать переменную (сохранять значение в локальную память потока)
     * и говорит о том, что ее значение нужно брать из основной памяти.
     * Когда к переменной идёт обращение из разных потоков стоить сделать ее volatile
     */
    private static volatile int number;
    private static int number2;

    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread decrementThread = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                number--;      // sample don't synchronized variable
                counter.dec(); // atomic integer
                dec(); // synchronized method
            }
        });


        Thread incrementThread = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                number++;// sample don't synchronized variable
                counter.increment();// atomic integer
                inc(); // synchronized method
            }
        });




        decrementThread.start();
        incrementThread.start();


        try {
            decrementThread.join();
            incrementThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(number);
        System.out.println(counter.getValue());
        System.out.println(number2);
    }

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
    static synchronized void dec() {
        number2--;
    }

    /**
     * Вариант выше и это единичны. В случае когда метод статичный, то в качестве монитора используется сам класс,
     * то есть {@link RaceCondition*class}. Когда метод не статичный, то используется сам объект(this) в качестве монитора
     *
     * Если например два метода синхронизированы по одному и тому же монитору, то пока один поток захватывает монитор
     * для первого метода, другие потоки не могут работать со вторым методом, так как монитор уже занят
     */
    static synchronized void inc() {
        synchronized (RaceCondition.class){
            number2++;
        }
    }


}

class Counter {

    /**
     * По умолчанию методы инкремента и декремента делают операцию за три шага:
     * 1. Получаем значение.
     * 2. Увеличиваем значение или уменьшаем.
     * 3. Присваиваем новое значение счетчику.
     *
     * Если мы работаем с одной переменной из разных потоков, то может возникнуть состояние гонки из-за того что некоторые
     * действия делаются не за одну операцию, а за несколько, например операция инкремента. Для которой нужно сделать
     * 3 действия, получить старое значение, увеличить на единицу, и поместить новое значение в переменную.
     * Атомарные типы данных(atomic) - предоставляют возможность делать все эти действия за одну операцию.
     * Тем самым, мы избегаем состояние гонки.
     * Это просто блочки над уже существующими типами(int, double, long). Это еще один способ как решить состояние гонки.
     *
     * Но даже atomic-и не являются потока безопасными
     */
    private final AtomicInteger value = new AtomicInteger();

    public void increment() { value.getAndIncrement(); }

    public void dec() { value.getAndDecrement(); }

    public int getValue() { return value.intValue(); }
}

