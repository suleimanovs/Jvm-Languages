package multithread.lesson4;

/**
 * Created by Osman on 3:12 PM
 */
class ATM {

    int amount;
    private final Object monitor = new Object();

    public ATM(int amount) {
        this.amount = amount;
    }

    public void withdraw(String personName, int amount) {
        synchronized (monitor) {

            System.out.println(personName + " подошел к банкомату");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            if (this.amount >= amount) {
                this.amount -= amount;
                System.out.println(personName + " вывел " + amount + " тенге");
                System.out.println("В банкомате осталось: " + this.amount + " тенге");
            } else System.out.println("В банкомате недостаточно денег для: " + personName + "\n");

        }
    }

}

public class HomeWork {
    public static void main(String[] args) {

        ATM atm = new ATM(1000);

        new Thread(() -> atm.withdraw("Osman", 300)).start();
        new Thread(() -> atm.withdraw("Suleiman", 500)).start();
        new Thread(() -> atm.withdraw("Omar", 400)).start();
        new Thread(() -> atm.withdraw("Sara", 200)).start();

    }
}
