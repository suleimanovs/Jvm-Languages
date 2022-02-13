package collections.info;

import java.util.HashSet;

/**
 * Created by Osman on 11:50 AM
 */
public class HashSetExample {

    public static void main(String[] args) {
        /**
         * HasSet - хранит только уникальные элементы, все дубликаты удаляются
         * а так же у него нет порядка, оно постоянно меняеться,
         * а так же элементы не доступны по индексу
         */
        HashSet<String> names = new HashSet<>();
        names.add("Osman");
        names.add("Suleiman");
        names.add("Suleiman");
        names.add("Sara");
        names.add("Omar");
    }
}
