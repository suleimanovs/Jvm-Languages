package generics;

import variables.Array;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Generics - это параметризованные типы. С их помощью можно
 * работать с классами, методами и интерфейсами, где тип данных указан в виде параметра
 * <p>
 * Ограничений на количество параметризованных параметров нет
 * <p>
 * Правила!
 * 1. В качестве параметра обобщенного типа можно использовать только ссылочные типы.
 * 2. Нельзя создать объект обобщенного типа: T obj = new T();
 * 3. Нельзя создать массив объектов обобщенного типа: (T[] array = new T[10])
 * <p>
 * <p>
 * Ключевое слово extends в параметризованном(обобщенном) классе указывает на то что мы можем
 * использовать либо сам класс который указан с права, либо его наследников(дочериных классов),
 * если мы хотим что бы тот класс не только наследовался от какого-то класса,
 * а так же реализовал интерфейсы, то можем это передать через символ амперсанд(&)
 * например - <T extends SomeClass & Comparable<T> & Serializable>
 */
public class Box<T extends Number & Comparable<T> & Serializable> {

    private final T[] array;

    @SafeVarargs
    public Box(T... array) {
        this.array = array;
    }

    public double average() {
        double sum = 0;
        for (T param : array) {
            sum += param.doubleValue();
        }
        return sum / array.length;
    }

    /**
     * @param numbers - метод ожидает лист типа Number, но не его наследников.
     *                То есть List<Integer> не является наследником List<Number>.
     *                У нас не получится передать в этот метод аргументы типа List<Integer>, List<Float>, List<Double> и т.д
     */
    public static void requireList(List<Number> numbers) {

    }

    public static void requireListWild(List<? extends Number> numbers) {

    }

    /**
     * Методы тоже можно параметризовать, указав тип параметра перед возвращаемым типом. Накладывать ограничения или
     * расширение и т.д
     */
    public static <Y extends CharSequence> Y peek(List<Y> list) {
        return list.get(0);
    }


    /**
     * ? - называется WildCard или маска, он означает что в метод [compare] может прилететь
     * Box параметризованный любым типом(точнее любого дочернего от Number, так как другие Box создать не получится)
     * Мы так же можем накладывать ограничение на WildCard, указав extends.
     * Мы могли бы обьявить метод так, но от такой записи толку нет( так как не получиться создать иное от Number)
     * <pre>{@code
     *     public int compareTo(Box<? extends Number> tBox) {
     *         return Double.compare(average(), tBox.average());
     *     }
     * }</pre>
     */
    public int compareTo(Box<?> tBox) {
        return Double.compare(average(), tBox.average());
    }


    /**
     * тут сообщается что лист источников может быть любой тип производный от U, а лист назначение может быть
     * любым классом из родителей U или сам U.
     */
    public static <U> void transfer(List<? extends U> src, List<? super U> dst) {
        dst.addAll(src);
        src.clear();
    }

    /**
     * Такой вариант не сработает так как мы хотим, при вызове этих методов, компилятор пожалуется:
     * transfer(listString, listCharSequence) error: Required type List<String> found List<CharSequence>
     * При таком объявления метода оба параметров должны быть списком одного и того же типа
     */
    public static <E> void transfer2(List<E> src, List<E> dst) {
        dst.addAll(src);
        src.clear();
    }

}

class Main {

    public static void main(String[] args) {

        var ints = new ArrayList<Integer>();
        var numbers = new ArrayList<Number>();

  //    Box.requireList(ints) List<Integer> не является наследником List<Number>
        Box.requireList(numbers);

    }

}
