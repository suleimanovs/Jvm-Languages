package multithread.lesson7;

/**
 * Created by osmanboy on 1/29/2022
 */
public class Main {

    public static void main(String[] args) {
        BlockingQueue blockingQueue = new BlockingQueue();

        new Thread(() -> {
            while (true) new Thread(blockingQueue.take()).start();

        }).start();


        for (int i = 0; i < 10; i++) {
            final int index = i;
            blockingQueue.add(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("task ---- " + index);

            });
        }
    }
}
