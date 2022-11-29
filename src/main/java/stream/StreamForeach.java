package stream;

import java.util.Arrays;

public class StreamForeach {
    public static void main(String[] args) {

        int[] ints = {1, 4, 23, 45, 6, 7, 6, 5, 65, 5, 3, 3443, 554, 2, 7, 6, 68, 9, 88, 5568,};

        Arrays.stream(ints).forEach(value -> {
            value *= 2;
            System.out.println(value);
        });

    }
}
