package multithread.lesson4;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Osman on 2:32 PM
 */
public class Counter {

    /**
     * По умолчанию методы инкримента и декремента делают операцию за три шага:
     * 1.Получаем значение.
     * 2.Увеличиваем значение или уменшаем.
     * 3.Присваеваем новое значение счетчику.
     *
     * Если мы работаем с одной переменной из разных потоков, то может возникнуть состояние гонки из-за того что некоторые
     * действия делаются не за одну операцию, а за несколько, например операция инкремента. Для которой нужно сделать
     * 3 действия, получить старое значение, увеличить на единицу, и поместить новое значение в переменную.
     * Атомарные типы данных(atomic) - предоставляют возможность делать все эти действия за одну операцию.
     * Тем самым, мы избегаем состояние гонки.
     * Это просто облочки над уже существующими типами(int, double, long). Это еще один способ как решить состояние гонки.
     */
    private AtomicInteger value = new AtomicInteger();

    public void increment() { value.getAndIncrement(); }

    public void dec() { value.getAndDecrement(); }

    public int getValue() { return value.intValue(); }
}