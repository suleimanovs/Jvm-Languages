package multithread.lesson7;

/**
 * Created by osmanboy on 1/29/2022
 */
public class HomeWork {

    public static final Object MONITOR = new Object();
    public static String A = "A";
    public static String B = "B";
    public static String C = "C";
    public static int PRINT_COUNT = 5;
    public static String CURRENT_STATE = "A";

    public static void main(String[] args) {
        startA();
        startB();
        startC();
    }

    private static void startB() {
        new Thread(() -> {
            synchronized (MONITOR) {
                for (int i = 0; i < PRINT_COUNT; i++) {
                    while (!CURRENT_STATE.equals(B)) {
                        try {
                            MONITOR.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print(B);
                    CURRENT_STATE = C;
                    MONITOR.notifyAll();


                }
            }
        }).start();
    }

    private static void startC() {
        new Thread(() -> {
            synchronized (MONITOR) {
                for (int i = 0; i < PRINT_COUNT; i++) {
                    while (!CURRENT_STATE.equals(C)) {
                        try {
                            MONITOR.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print(C);
                    CURRENT_STATE = A;
                    MONITOR.notifyAll();
                }
            }
        }).start();
    }

    private static void startA() {
        new Thread(() -> {
            synchronized (MONITOR) {
                for (int i = 0; i < PRINT_COUNT; i++) {
                    while (!CURRENT_STATE.equals(A)) {
                        try {
                            MONITOR.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print(A);
                    CURRENT_STATE = B;
                    MONITOR.notifyAll();

                }
            }
        }).start();
    }

}
