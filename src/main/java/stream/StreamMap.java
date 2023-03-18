package stream;

import variables.Array;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Stream – это последовательность элементов, поддерживающих последовательные и параллельные операции над ними.
 * Stream используется для работы с коллекциями в функциональном стиле.
 * <p>
 * 1.Все операторы по работе со стримами деляться на два типа:
 * промежуточные.
 * завершающие(терминальные)
 * <p>
 * 2.Терминальные операторы завершают работу потока.
 * 3.Промежуточных операторов в потоке может быть сколько угодно, терминальный только один.
 * 4.Терминальный оператор запускает на выполнение прoмежутчные операторы.
 *
 * Методы Stream не меняют саму коллекцию или массив, от которой был создан stream
 */
public class StreamMap {

    public static void main(String[] args) {
        var stringList = new ArrayList<String>();
        stringList.add("Hello");
        stringList.add("how are you");
        stringList.add("what do u do");
        stringList.add("something");

        /**
         * Map - T->R, он выполняет операцию над каждым элементом в потоке, на выходе объект может иметь любой другой тип
         */
        List<Integer> integers = stringList.stream().map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        }).collect(Collectors.toList());


        for (int integer : integers) {
            System.out.println(integer);
        }




    }
}
