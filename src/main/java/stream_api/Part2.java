package stream_api;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Osman on 15:04
 */
public class Part2 {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add((int) (Math.random() * 1000));
        }

        List<Integer> newList = filter(list, (a) -> a % 2 == 0);

        /**
         * 1.Все операторы по работе со стримами деляться на два типа:
         *      промежуточные.
         *      завершающие(терминальные)
         *
         * 2.Терминальные операторы завершают работу потока.
         * 3.Промежуточных операторов в потоке может быть сколько угодно, терминальный только один.
         * 4.Терминальный оператор запускает на выполнение прoмежутчные операторы.
         */
        List<String> filtered = newList.stream()
                .filter((n) -> n % 2 == 0)
                .map((integer) -> "Number: " + integer)
                .filter((string) -> string.endsWith("0"))
                .map((a) -> a + "!")
                .collect(Collectors.toList());
    }


    private static List<Integer> filter(List<Integer> src, Predicate predicate) {
        List<Integer> list = new ArrayList<>();
        for (Integer integer : src) if (predicate.test(integer)) list.add(integer);
        return list;
    }


}

@FunctionalInterface
interface Predicate {

    boolean test(int a);

}

