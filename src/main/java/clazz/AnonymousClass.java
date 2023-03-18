package clazz;

public class AnonymousClass {
    public static void main(String[] args) {

        var childSingleton = new ParentClass() {
            @Override
            void aVoid() {
                System.out.println("child");
            }
        };

    }

}

/**
 * Anonymous класс – это «объявление» класса и одновременное создание объекта
 * • Анонимный класс может обращаться даже к private элементам внешнего класса
 * • Lambda expressions – это краткая форма для написания анонимных классов
 * • Anonymous класс не имеет имени
 * • В анонимных классах невозможно написать конструктор
 */

class ParentClass {
    void aVoid() {
        System.out.println("child");
    }
}