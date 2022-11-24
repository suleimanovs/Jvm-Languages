package stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by Osman on 11:04
 */
public class Part3 {

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Osman", 19));
        users.add(new User("Sara", 56));
        users.add(new User("Sofia", 34));
        users.add(new User("Dilan", 13));
        users.add(new User("Rukia", 21));
        users.add(new User("Omar", 15));
        users.add(new User("Suleiman", 11));
        users.add(new User("Asia", 14));


        /**
         * Терминальный оператор {@link Stream#count()} так же завершае работу промежуточных,
         * и возвращает long, количестов потоков
         */
        long count = users.stream()
                .filter((user) -> user.getAge() > 20)
                .count();


        /**
         * Терминальный оператор {@link Stream#allMatch(Predicate)} так же завершает работу промежуточных,
         * и возвращает true, если предикат для всех элеменов вернет true, если предикат хоть для одного
         * элмента вернет false, то и весь метод вернет false
         */
        boolean isCanGoToHorrorCheckForAll = users.stream()
                .allMatch((user -> user.getAge() > 10));


        /**
         * Терминальный оператор {@link Stream#anyMatch(Predicate)} так же завершает работу промежуточных,
         * и возвращает true, если предикат хотя бы для одного элемента вернет true, иначе false
         */
        boolean isCanGoToHorrorCheckForAny = users.stream()
                .anyMatch((user -> user.getAge() > 25));


        /**
         * HOMEWORK
         */

        users.stream()
                .sorted(Comparator.comparing(User::getName))
                .filter(user -> user.getAge()<40)
                .limit(3)
                .map(User::getName)
                .forEach(System.out::println);


    }
}

