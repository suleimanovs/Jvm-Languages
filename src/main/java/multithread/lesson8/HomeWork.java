package multithread.lesson8;

/**
 * Created by osmanboy on 1/29/2022
 */
public class HomeWork {
    public static void main(String[] args) {
        MFD mfd = new MFD();

        new Thread(() -> {
            mfd.print(5);
        }).start();

        new Thread(() -> {
            mfd.print(5);

        }).start();

        new Thread(() -> {
            mfd.scan(5);

        }).start();

    }
}

class MFD {

    public static final Object SCAN_MONITOR = new Object();
    public static final Object PRINT_MONITOR = new Object();

    public void scan(int pageCount) {
        synchronized (SCAN_MONITOR) {
            for (int i = 1; i <= pageCount; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " Scanned: " + i + "page");
            }
        }
    }

    public synchronized void print(int pageCount) {
        synchronized (PRINT_MONITOR) {
            for (int i = 1; i <= pageCount; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " Printed: " + i + "page");
            }
        }
    }

}
