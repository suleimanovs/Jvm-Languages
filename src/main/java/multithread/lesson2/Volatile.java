package multithread.lesson2;

class WithoutVolatile extends Thread{

    static boolean bool = true;

    @Override
    public void run() {
        long counter = 0;
        while (bool) {
            counter++;
        }
        System.out.println("Loop is finished. counter = " + counter);
    }

    public static void main(String[] args) throws InterruptedException {
        /**
         * {@link thread} - скорее никогда н закончит свою работу, так как поток не в курсе,
         * что значение переменной {@link bool} изменилась. По скольку каждый поток работает в ядре,
         * то для быстрого доступа каждый поток может кешировать значение переменной из общей памяти в CPU Cash ядра.
         * Что бы ядро каждый раз не обращался к общей памяти. По этому неизвестно когда ядро обратиться
         * к общей памяти снова и изменит значение у себя тоже. Эту проблему решает ключевое слово volatile.
         */
        WithoutVolatile withoutVolatile = new WithoutVolatile();
        withoutVolatile.start();
        Thread.sleep(3000);
        System.out.println("After 3 seconds it is time to wake up!");
        bool = false;
        withoutVolatile.join();
    }


}


public class Volatile {

    /**
     * Когда мы отмечаем переменную ка volatile, тем самым мы запрещаем потокам кешировать значение данной переменной
     * в свой CPU Cash. Мы даем понять что всегда нужно брать значение из общей памяти
     *
     * Ключевое слово volatile используется для пометки переменной, как хранящейся только в основной памяти «main memory».
     * Для синхронизации значения переменной между потоками ключевое слово volatile используется тогда,
     * когда только один поток может изменять значение этой переменной, а остальные потоки могут его только читать.
     *
     * Отметка переменно как volatile не делает ее потока безопасным
     */
   volatile static boolean bool = true;

    public static void main(String[] args) throws InterruptedException {


        var thread = new Thread(() -> {
            long counter = 0;
            while (bool) {
                counter++;
            }
            System.out.println("Loop is finished. counter = " + counter);
        });


        thread.start();
        Thread.sleep(3000);
        System.out.println("After 3 seconds it is time to wake up!");
        bool = false;
        thread.join();


    }

}