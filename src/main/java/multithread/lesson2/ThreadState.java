package multithread.lesson2;

public class ThreadState {

    public static void main(String[] args) throws InterruptedException {

        var thread  = new Thread(() -> {
            for (int i = 0; i < 10; i++){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
        thread.join();
        System.out.println(thread.getState());


    }

}
