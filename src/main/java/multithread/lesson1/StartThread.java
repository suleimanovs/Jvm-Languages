package multithread.lesson1;

public class StartThread {

    public static void main(String[] args) {

        Thread first = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }, "Cool Thread");

        /**
         * Поток нужно запустить с помощью метода Thread.start(), никогда не стоит запустить поток с помощью
         * метода Thread.run(). Так как в этом случае новый поток создан не будет. И код внутри метод run будет выполняться
         * на главном потоке(то есть на том потоке в котором был вызван)
         */

        first.run(); // Thread name is - main. Код внутри run был вызван на главном потоке

        first.start(); // Thread name is - Cool Thread. Код внутри run был вызван на другом потоке
    }

}
