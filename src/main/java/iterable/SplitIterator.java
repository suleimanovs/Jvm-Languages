package iterable;

import collections.list.ArrayList;

import java.util.HashMap;

public class SplitIterator {

    public static void main(String[] args) {

        var list = new ArrayList<Integer>();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }

        /**
         * все способности SplitIterator рассмотреть не будем, только ту способность которая содержится в его имени.
         * А именно метод trySplit(). Он выгрызает итератор на двое, используется в случаях когда нужно произвести
         * вычисления параллельно
         */
        var splitIterator = list.spliterator();

        var subIterator = splitIterator.trySplit();


        while (splitIterator.tryAdvance(System.out::println)) ; // 6,7,8,9,10

        while (subIterator.tryAdvance(System.out::println)) ; // 1,2,3,4,5
    }

}
