package generic;

import java.io.Serializable;
import java.util.List;

/**
 * Generics - это параметризованные типы. С их помощью можно
 * работать с классами, методами и интерфейсами, где тип данных указан в виде параметра
 *
 * Ограничений на количество параметризованных параметров нет
 *
 * Правила!
 * 1. В качестве пармера обобщенного типа можно использовать только ссылочные типы.
 * 2. Нельзя создать обьект обобщенного типа. example: (T obj = new T();)
 * 3. Нельзя создать массив обьектов обобщенного типа: (T[] array = new T[10])
 *
 *
 * Ключевое слово extends в параметризованном(обобщенном) классе  указывает на то что мы можем
 * использовать либо сам класс который указан с права, либо его наследников(дочерных классов),
 * если мы хотим что бы тот класс не только наследовался от какого-то класса,
 * а так же реализовал интерфейсы, то можем это передать через символ амперсант(&)
 * например - <T extends SomeClass & Comparable<T> & Serializable>
 * */
public class Box<T extends Number & Comparable<T> & Serializable> {

    private final T[] array;

    @SafeVarargs
    public Box(T...array){
        this.array =array;
    }

    public double average(){
        double sum = 0;
        for(T param:array){
            sum+=param.doubleValue();
        }
        return sum/array.length;
    }

    public static void requireList(List<Number> numbers){

    }

    public static void requireListWild(List<? extends Number> numbers){

    }


    /**
     * ? - называется WildCard или маска, он озночает что в метод [compare] может прилететь
     * Box параметризованный любым типом.
     * Мы так же можем накладывать ограничение на WildCard, указав extends
     */
    public int compareTo(Box<?> tBox){
        return Double.compare(average(), tBox.average());
    }



   public static <U> void transfer(List<? extends U> src, List<? super U> dst){
        dst.addAll(src);
        src.clear();
   }

}
