package multithread.lesson8;

/**
 * Deadlock - взаимная блокировка. Явление, при котором все потоки находятся в режиме ожидания.
 * Deadlock – ситуация, когда 2 или более потоков заблочены навсегда, ожидают друг друга и ничего не делают.
 * Deadlock возникает по причине не правильной последовательности захвата мониторов
 *
 *
 * Livelock – ситуация, когда 2 или более потоков заблочены навсегда, ожидают друг друга, проделывают какую-то
 * работу, но без какого-либо прогресса.
 *
 * Lock starvation – ситуация, когда менее приоритетные потоки ждут долгое время или всё время для того, чтобы
 * могли запуститься
 */
class Account{

    int amount1;
    int amount2;

    private final Object monitor1 = new Object();
    private final Object monitor2 = new Object();

    public Account(int amount1, int amount2) {
        this.amount1 = amount1;
        this.amount2 = amount2;
    }

    /**
     * эти переводы не выполняться, так как эти две потоки просто заблокируют друг друга,
     */
    public void transferFrom1To2(int amount){
        synchronized (monitor1){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            if(amount<=amount1){
                System.out.println("amount<=amount1");
                synchronized (monitor2){
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                    amount1-=amount;
                    amount2+=amount;
                }
            }else System.out.println("Insufficient funds");

        }
    }


    public void transferFrom2To1(int amount){
        synchronized (monitor2){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            if(amount<=amount2){
                System.out.println("amount<=amount2");
                synchronized (monitor1){
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                    amount1+=amount;
                    amount2-=amount;
                }
            }else System.out.println("Insufficient funds");

        }
    }
}

public class Deadlock {

    public static void main(String[] args) {
        Account account = new Account(1000,1000);

        new Thread(()-> account.transferFrom1To2(300)).start();
        new Thread(()-> account.transferFrom2To1(500)).start();
    }
}
