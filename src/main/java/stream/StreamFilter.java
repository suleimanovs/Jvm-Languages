package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilter {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add((int) (Math.random() * 1000));
        }

        /**
         * фильтрация без стримов.
         */
        List<Integer> result = new ArrayList<>();
        Predicate predicate = (a) -> a % 2 == 0;
        for (Integer integer : list) {
            if (predicate.test(integer)) {
                result.add(integer);
            }
        }


        /**
         *
         */
        List<Integer> filtered = list.stream()
                .filter((n) -> n % 2 == 0)
                .collect(Collectors.toList());
    }



}

@FunctionalInterface
interface Predicate {

    boolean test(int a);

}
