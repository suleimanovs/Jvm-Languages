package multithread.lesson1;

/**
 * Created by osmanboy on 1/28/2022
 *
 * Многопоточность - средство которая позволяет выполнять несколько задачи одновременно в разных потоках.
 *
 * Многопоточность на основе процессов - дает возможность программам
 * или процессам работать паралельно
 *
 * Многопоточность на основе потоков - дает возможность выполнят несколько задач
 * одновременно в рамках одной программы.
 *
 * Что бы запустить поток нужно вызвать метод {@link Thread#start} , а не run.
 * Если вызвать {@link Thread#run}то код выполниться в главном потоке, ее вызвать в ручную вообще не нужно.
 * Для создания нового потока, вызвать необходимо только {@link Thread#start}
 *
 */
public class Main {
    public static void main(String[] args) {

        //1
        MyThread myThread = new MyThread();
        myThread.start();

        //2
        Thread thread1 = new Thread(new MyRunnable());
        thread1.start();

        //3
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) System.out.println(i);

            }
        });
        thread2.start();

    }
}
