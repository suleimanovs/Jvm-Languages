package multithread.lesson1;


public class InterruptStopThread {

    public static void main(String[] args) throws InterruptedException {

        var stopThread = new StopThread();

        stopThread.start();
        Thread.sleep(400);
        /**
         * В старых версиях java, поток останавливали с помощью метода {@link Thread#stop()}. Но этот способ являлся
         * не правильным. Так как поток мог делать io операций и подобное. Принудительная остановка потока, приводит
         * к ошибкам и к неожиданным последствиям.
         */
        stopThread.stop();


        // Правильный способ

        var interruptThread = new InterruptThread();

        interruptThread.start();
        Thread.sleep(400);
        /**
         * Метод {@link Thread#interrupt()}  не останавливает поток. А лишь устанавливает значение флага isInterrupt
         * в true. И мы сами должны в методе {@link Runnable#run()} реагировать на это как то.
         * У нас есть возможность послать сигнал потоку, что мы хотим его прервать.
         * У нас также есть возможность в самом потоке проверить, хотят ли его прервать. Что делать, если данная проверка
         * показала, что поток хотят прервать, должен решать сам программист
         */
        interruptThread.interrupt();







    }
}

class StopThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(100);
                System.out.println(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}


class InterruptThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {

            /**
             * Если значение флага isInterrupt установлен в true, то останавливаем цикл, тем самым
             * выходим из метода. В зависимости от этого можно реализовать всякие действия
             */
            if(isInterrupted()){
                return;
            }

            try {
                /**
                 * Если вызвать метод {@link Thread#interrupt()} пока поток спит, то будет брошено ошибка.
                 * По этому если остановят поток пока то спит. Мы обработаем эту ошибку. И выйдем из метода
                 * прописав return statement в блоке catch
                 */
                Thread.sleep(100);
                System.out.println(i);
            } catch (InterruptedException e) {
                System.out.println(i);
                e.printStackTrace();
                return;
            }
        }
    }

}
