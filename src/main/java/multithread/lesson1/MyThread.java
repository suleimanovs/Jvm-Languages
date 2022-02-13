package multithread.lesson1;

/**
 * Created by osmanboy on 1/28/2022
 */

/**
 * Этот способ не рекомендуется, так как в Java запрещено множественное наследование от классов,
 * то есть если наш класс уже наследован от какого то класса, то мы не сможем наследоватьься и от Thread
 */
public class MyThread extends Thread {
    @Override
    public void run() {

        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
    }
}
