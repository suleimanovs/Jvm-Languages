package multithread.lesson2;

/**
 * Created by osmanboy on 1/28/2022
 * <p>
 * Метод stop - который мгновенно останавливает поток, устаревший(так как мы можем остановитть поток,
 * вовремя выполнения важной задачи и тем самым повредить что-то), вместо этого есть метод interrupted.
 * Который устанавливает значение метода {@link Thread#isInterrupted()} в true.
 * и мы должны явно обработать в методе({@link Thread#run()}),
 * и сами решить как остановит поток если  {@link Thread#isInterrupted()} вернет true.
 * После остановки потока, снова начать ее выполнение нельзя.
 */
public class Main {

    public static void main(String[] args) {


        Thread thread = new Thread(() -> {
            try {

                for (int i = 0; i < 1000; i++) {
                    if (Thread.currentThread().isInterrupted()) break;
                    System.out.println(i);
                    Thread.sleep(1000); // останавливаем поток на секунду
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.start();

        for (int i = 0; i < 1000; i++) {
            if (i == 100) {
                // thread.stop(); deprecated
                thread.interrupt(); // не останавливает поток, а лишь изменяет значение флага isInterrupted в true
            }
            System.out.print("M");
        }

        // thread.start() - так делать нельзя, снова начать выполнение потока который остановлен нельзя.
    }
}
