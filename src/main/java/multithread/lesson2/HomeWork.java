package multithread.lesson2;

import java.util.Arrays;

/**
 * Created by osmanboy on 1/28/2022
 */
class HomeWork {

    static final int SIZE = 50_000_000;
    static final int HALF = SIZE / 2;

    static void withConcurrency() {
        float[] array = new float[SIZE];
        Arrays.fill(array, 1f);

        long before = System.currentTimeMillis();
        float[] firstToMiddle = new float[HALF];
        float[] middleToLast = new float[HALF];
        System.arraycopy(array, 0, firstToMiddle, 0, firstToMiddle.length);
        System.arraycopy(array, 5_000_000, middleToLast, 0, middleToLast.length);
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < firstToMiddle.length; i++) {
                float f = (float) i;
                firstToMiddle[i] = (float) (firstToMiddle[i] * Math.sin(0.2f + f / 5) * Math.cos(0.2f + f / 5) * Math.cos(0.4f + f / 2));
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < firstToMiddle.length; i++) {
                float f = (float) (i + HALF);
                middleToLast[i] = (float) (middleToLast[i] * Math.sin(0.2f + f / 5) * Math.cos(0.2f + f / 5) * Math.cos(0.4f + f / 2));
            }
        });


        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(firstToMiddle, 0, array, 0, firstToMiddle.length);
        System.arraycopy(middleToLast, 0, array, HALF, middleToLast.length);

        long after = System.currentTimeMillis();

        System.out.println("WithConcurrency: " + (after - before));

    }

    static void withoutConcurrency() {
        float[] array = new float[SIZE];
        Arrays.fill(array, 1);
        long before = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            float f = (float) i;
            array[i] = (float) (array[i] * Math.sin(0.2f + f / 5) * Math.cos(0.2f + f / 5) * Math.cos(0.4f + f / 2));
        }
        long after = System.currentTimeMillis();

        System.out.println("WithoutConcurrency: " + (after - before));


    }



    public static void main(String[] args) {
        withConcurrency();
        withoutConcurrency();
    }


}
