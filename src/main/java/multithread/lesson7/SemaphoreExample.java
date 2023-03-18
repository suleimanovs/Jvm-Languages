package multithread.lesson7;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    public static void main(String[] args) {

        /**
         * Semaphore – это синхронизатор, позволяющий ограничить доступ к какому-то ресурсу. В конструктор
         * Semaphore нужно передавать количество потоков, которым Semaphore будет разрешать одновременно
         * использовать этот ресурс.
         */
        var semaphore = new Semaphore(2); // к ресурсу доступ могут получить одновременно только 2 потока
        new Person("Osman",semaphore );
        new Person("Oleg",semaphore );
        new Person("Ivan",semaphore );
        new Person("Marsel",semaphore );
        new Person("Nikita",semaphore );
        

    }

}

class Person extends Thread {

    private final Semaphore callBox;
    private final String name;

    public Person(String name,Semaphore callBox) {
        this.callBox = callBox;
        this.name = name;
        this.start();
    }

    @Override
    public void run() {

        try {
            System.out.println(name + " ждет...");
            callBox.acquire(); // уменьшаем счетчик на единицу
            System.out.println(name + " пользуется телефонной будкой");
            sleep(2000);
            System.out.println(name + " завершил звонок");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Увеличиваем счетчик на единицу. Рекомендуется всегда делать в блоке finally
            callBox.release();
        }

    }
}
