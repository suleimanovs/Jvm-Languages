package collections.info;

import collections.model.Car;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Osman on 11:53 AM
 */
public class TreeSetExample {

    public static void main(String[] args) {
        /**
         * TreeSet - хранит только уникальные элементы, все дубликаты удаляются
         * но в отличие от HashSet она хранит все элменты в отсортированном виде(по алфавиту,по возрастанию)
         * а так же элементы не доступны по индексу. и она медленнее HashSet
         */

        Set<Car> cars = new TreeSet<Car>(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.getBrand().compareTo(o2.getBrand());
            }
        });
        for (int i = 0; i < 100; i++) cars.add(new Car("Brand" + i, i));

        for (Car car : cars) System.out.println(car.toString());

        Set<Integer> integers = new TreeSet<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) return -1;

                else if (o1 < o2) return 1;

                else return 0;

            }
        });

        for (int i = 0; i < 100; i++) integers.add(i);
        for (Integer num : integers) {
            System.out.println(num);
        }


    }
}
