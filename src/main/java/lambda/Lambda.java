package lambda;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Самый короткий вариант написания лямбда выражения:
 * <pre>{@code
 *     stud -> stud.avgGrade > 8.5
 * }
 * </pre>
 * <p>
 * Более полный вариант написания лямбда выражения:
 * <pre>{@code
 *     (Student stud) -> {return stud.avgGrade > 8.5;}
 * }
 * </pre>
 * <p>
 * В лямбде выражении оператор стрелка разделяет параметры метода и тело метода.
 * В лямбде выражении справа от оператора стрелка находится тело метода, которое было бы у метода соответствующего класса,
 * имплантировавшего наш интерфейс с единственным методом.
 * Вы можете использовать смешанный вариант написания лямбда выражения:
 * слева от оператора стрелка писать короткий вариант, справа – полный. Или наоборот.
 * Если вы используете полный вариант написания для части лямбда выражения справа от стрелки, то вы должны использовать слово return и знак «;»
 * Левая часть лямбда выражения может быть написана в краткой форме, если метод интерфейса принимает только 1 параметр. Даже если метод
 * интерфейса принимает 1 параметр, но в лямбде выражении вы хотите писать данный параметр используя его тип данных, тогда уже вы должны писать
 * левую часть лямбда выражения в скобках.
 * Если в правой части лямбда выражения вы пишите более одного statement-а, то вы должны использовать его полный вариант написания
 */
public class Lambda {
    /**
     * В пакете java.util.function есть большая сборка функциональных интерфейсов, которых можно использовать в лямбда
     * выражениях
     */
    public static void main(String[] args) {


        Predicate<Integer> predicate1 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 0;
            }
        };

        Predicate<Integer> predicate2 = integer -> integer % 2 == 0;


        Stream<Integer> stream = Stream.of(12, 43, 56, 87, 67, 90, 98, 3, 26, 389, 58, 0, 4357, 9, 8, 777, 6, 655, 433, 222456, 7);

        stream.filter(predicate1).forEach(System.out::println);
    }
}