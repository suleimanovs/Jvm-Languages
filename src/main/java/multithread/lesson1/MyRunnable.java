package multithread.lesson1;

/**
 * Created by osmanboy on 1/28/2022
 */

/**
 * Такой способ предпочтительнее так как Runnable это интерфейс а не класс, то есть
 * интерфейсов реализовать можем столько сколько угодно.
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) System.out.println(i);
    }
}
