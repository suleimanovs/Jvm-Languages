package multithread.lesson1;

public class SleepThread {

    public static void main(String[] args) {

        /**
         * усыпить поток можно с помощью метода {@link Thread#sleep(long)}, но этот метод выбрасыает лшибку
         * времени компиляций
         * @throws InterruptedException
         * Это ошибка будет брошено в случае если другой поток попросить этот поток остановиться, то есть вызвать метод:
         * {@link Thread#interrupt()} , а наш поток в это время спал
         */
        var thread = new Thread(() -> {

            for (int i = 0; i < 10; i++) {

                System.out.println(i);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        thread.start();
        System.out.println("Поток "+Thread.currentThread().getName()+" продолжает свою работу");



    }

}
