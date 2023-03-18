package multithread.lesson7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Exchanger;

public class ExchangerExample {

    public static void main(String[] args) {

        Exchanger<Action> exchanger = new Exchanger<>();

        List<Action> friend1Action = new ArrayList<>();
        friend1Action.add(Action.NOJNICI);
        friend1Action.add(Action.BUMAGA);
        friend1Action.add(Action.NOJNICI);

        List<Action> friend2Action = new ArrayList<>();
        friend2Action.add(Action.BUMAGA);
        friend2Action.add(Action.KAMEN);
        friend2Action.add(Action.KAMEN);

         new BestFriend("Vanya",exchanger,friend1Action);
         new BestFriend("Petya",exchanger,friend2Action);

    }

}

enum Action {
    KAMEN, NOJNICI, BUMAGA
}

class BestFriend extends Thread {

    /**
     * Exchanger – это синхронизатор, позволяющий обмениваться данными между двумя потоками,
     * обеспечивает то, что оба потока получат информацию друг от друга одновременно.
     */
    private final Exchanger<Action> exchanger;
    private final String name;
    private List<Action> actions;

    public BestFriend(String name, Exchanger<Action> exchanger, List<Action> actions) {
        this.exchanger = exchanger;
        this.name = name;
        this.actions = actions;
        this.start();
    }

    private void whoWins(Action myAction, Action friendAction) {

        if ((myAction == Action.KAMEN && friendAction == Action.NOJNICI) ||
                (myAction == Action.NOJNICI && friendAction == Action.BUMAGA) ||
                (myAction == Action.BUMAGA && friendAction == Action.KAMEN)
        ) {
            System.out.println(name + " win");
        }

    }

    @Override
    public void run() {

        Action reply;
        for (Action action : actions) {
            try {
                reply = exchanger.exchange(action);
                whoWins(action, reply);
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

}