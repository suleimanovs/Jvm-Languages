package multithread.lesson1;

public class ThreadNameAndPriority {

    public static void main(String[] args) {

        /**
         * default name у потоков начинается с Thread - n(где n последовательность чисел)
         * default priority у потоков 5 по 10 бальной шкале.
         */
        Thread first = new Thread(() -> System.out.println("How are you?"));
        Thread second = new Thread(() -> System.out.println("Hello!"));

        /**
         * Можем изменять мена у потоков, а так же приоритетность, но это не значит что поток с наибольшим приоритетом
         * запустить первым и т.д
         */
        first.setName("First Thread");
        second.setName("Second Thread");
        first.setPriority(Thread.MIN_PRIORITY);
        second.setPriority(Thread.MAX_PRIORITY);

        first.start();
        second.start();

    }

}
