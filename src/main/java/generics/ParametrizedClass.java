package generics;

public class ParametrizedClass {

    public static void main(String[] args) {

        /**
         * Везде в классе Info где есть параметризованный тип T будет вставлен String
         */
        var stringInfo = new Info<String>("str");
        var intInfo = new Info<Integer>(12);

    }

}


/**
 * @param <T> - везде вместо этого параметра будет вставлен реальный тип. Просто подстановка. Вместо символа T
 * можно написать любой другой символ. И даже не один символ. Но принято:
 * E - для элементов списка и т.д.
 * K - для ключей.
 * V - для значений(value)
 * Статические параметризованные типы создавать нельзя. Потому что статические переменные ни как не связаны с созданием
 * объекта. Они для класса. И для всех объектов в единственном экземпляре.
 */
class Info<T> {

    private T value;

    public Info(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Info{" +
                "value=" + value +
                '}';
    }
}
