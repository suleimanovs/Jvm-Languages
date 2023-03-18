package multithread.lesson1;

/**
 * Created by osmanboy on 1/28/2022
 * <p>
 * Многопоточность - средство которая позволяет выполнять несколько задачи одновременно в разных потоках.
 * <p>
 * Многопоточность на основе процессов - дает возможность программам
 * или процессам работать паралельно
 * <p>
 * Многопоточность на основе потоков - дает возможность выполнят несколько задач
 * одновременно в рамках одной программы.
 * <p>
 * Что бы запустить поток нужно вызвать метод {@link Thread#start} , а не run.
 * Если вызвать {@link Thread#run}то код выполниться в главном потоке, ее вызвать в ручную вообще не нужно.
 * Для создания нового потока, вызвать необходимо только {@link Thread#start}
 */
public class MultiThreadIntroduction {
    public static void main(String[] args) {

        //1
        MyThread myThread = new MyThread();
        myThread.start();

        //2
        Thread thread1 = new Thread(new MyRunnable());
        thread1.start();

        //3 можно и лямбду писать
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) System.out.println(i);

            }
        });
        thread2.start();

    }
}

/**
 * Такой способ предпочтительнее так как Runnable это интерфейс, а не класс, то есть
 * интерфейсов реализовать можем столько сколько угодно.
 */
class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) System.out.println(i);
    }
}


/**
 * Этот способ не рекомендуется, так как в Java запрещено множественное наследование от классов,
 * то есть если наш класс уже наследован от какого то класса, то мы не сможем наследоватьься и от Thread
 */
class MyThread extends Thread {
    @Override
    public void run() {

        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
    }
}
