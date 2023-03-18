package modificators;


class Person {

    /**
     * К final переменным нужно либо сразу присвоить значение, либо сделать это во всех конструторах
     *
     * final - помечается в трех случаях:
     * 1.Переменная завершенная, ее больше не получиться изменить(присвоить новое значение)
     * 2.Класс не доступен для наследования
     * 3.код класса не доступен для переопределения
     */
    public final String name;
    public final String type = "primat";
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class Final {


    public static void main(String[] args) {

        Person person = new Person("Ivan", 22);
        // person.name="Maxim"; error, name is final
        person.age = 23;

    }
}
