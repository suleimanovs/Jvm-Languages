package multithread.lesson3;

/**
 * Created by osmanboy on 1/28/2022
 * Есть два видов потока:
 * - Основные(важные) потоки.
 * - Daemon(неважные) потоки.
 */
public class DaemonThread {
    /**
     * Daemon Thread - не важные потоки. Он завершается сразу после завершения всех основных потоков.
     * Для этого нужно у потока вызвать метод {@link Thread#setDaemon}, потоки-демоны завершают свою работу автоматически
     * после завершения всех основных потоков.
     *
     * Daemon потоки предназначены для выполнения фоновых задач и оказания различных сервисов User потокам.
     *
     * При завершении работы последнего User потока программа завершает своё выполнение, не дожидаясь окончания работы
     * Daemon потоков
     */
    static void startTimer() {
        Thread thread = new Thread(() -> {

            try {
                int seconds = 0;
                while (true) {
                    System.out.println(++seconds);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        /**
         * Поток нужно сделать демоном еще до его запуска. Если вызвать метод setDaemon после того как поток
         * уже запущен, будет брошено ошибка
         */
        thread.setDaemon(true);//делаем его потоком демоном
        thread.start();

    }

    public static void startLoadReceiveData() {
        new Thread(() -> {
            System.out.println("Start load data");
            for (int i = 0; i < 50; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Finish load data");
        }).start();

        new Thread(() -> {
            System.out.println("Start receive data");
            for (int i = 0; i < 50; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Finish receive data");
        }).start();
    }

    public static void main(String[] args) {
        startTimer();
        startLoadReceiveData();
    }
}
