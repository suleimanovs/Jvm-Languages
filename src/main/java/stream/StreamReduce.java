package stream;

import java.util.stream.Stream;

public class StreamReduce {

    public static void main(String[] args) {

        Stream<Integer> integerStream = Stream.of(2, 33, 54, 67, 89, 4, 12, 33, 2, 4, 5, 3);
        /**
         * reduce - возвращает в конце только один элемент
         */
        int sum = integerStream.reduce((accumulator, element) -> accumulator += element).get();
        System.out.println(sum);


    }

}
