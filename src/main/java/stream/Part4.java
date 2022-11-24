package stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Osman on 11:52
 */
public class Part4 {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Osman", 19));
        users.add(new User("Sara", 56));
        users.add(new User("Sofia", 34));
        users.add(new User("Dilan", 13));
        users.add(new User("Ruckia", 21));
        users.add(new User("Omar", 15));
        users.add(new User("Suleiman", 11));
        users.add(new User("Asia", 14));


        Optional<User> userOldest = users.stream().max(Comparator.comparingInt(User::getAge));

        userOldest.ifPresent(System.out::println);


        users.stream()
                .filter((user -> user.getName().contains("l")))
                .findFirst()
                .ifPresentOrElse(System.out::println, () -> System.out.println("User not found"));


        /**
         * Способ создания стриммов для массива
         */
        int[] array = {3, 1, 3, 5, 14};

        Arrays.stream(array);//1
        Stream.of(array);//2


        List<Float> floatList = new ArrayList<>();
        for (int i = 0; i < 30_000_000; i++) {
            floatList.add((float) i);
        }



        long before = System.currentTimeMillis();
        /**
         * {@link Collection#parallelStream()} делает каждые вычеления потоков в разных потоках
         */
        floatList.parallelStream()
                .map((number) -> Math.sin(0.2f + number / 5) * Math.cos(0.2f + number / 5) * Math.sin(0.4f + number / 2))
                .collect(Collectors.toList());
        long after = System.currentTimeMillis();

        System.out.println(after - before);


    }
}
