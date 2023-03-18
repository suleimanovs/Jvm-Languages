package oop.inheriate;

/**
 * Created by Osman on 12:44
 */

public class Main {


    static void printName(CatFamily catFamily){
        System.out.println("CatFamily");
    }

    static void printName(Lion lion){
        System.out.println("Lion");
    }

    public static void main(String[] args) {
        CatFamily catFamily = new Lion(2, 4);
        Lion lion = new Lion(2, 4);
        Cat cat = new Cat();

        /**
         * Несмотря на то, что catFamily переменная reference типа Employee, вызвался метод из Lion. Так как java
         * основывается на объекте который был создан.
         * Binding - определение вызываемого метода, основываясь на объекте, которы производит вызов
         * или типе данных reference variable. Binding делится на два типа:
         *
         * 1. Compile time binding - во время компиляций программы, он так же назовется static binding. К этому типу binding
         * относится - [private methods, static methods, final methods] все трое не могут быть override (перезаписаны).
         * Все переменные имеют тип compile time binding, не могут быть override (перезаписаны).
         *
         * 2. Run time binding -во время выполнения программы, он так же назовется lazy binding. Когда
         * compilator не в силах разузнать к какому объекту будет относиться метод. К этому типу binding относится
         * все другие методы. run time binding не распространяется на переменных
         */
        catFamily.eat();
        lion.eat();
        cat.eat();

        /**
         * Все переменные имеют тип compile time binding
         * Compile time видно что переменная catFamily2 является типом CatFamily, по этому вызывается метод printName
         * который принимает в параметре CatFamily объект.
         */
        CatFamily catFamily2= new Lion(2,4);
        printName(catFamily); // CatFamily

        /**
         * В этом случае runtime определял бы что нужно вызвать метод из Lion. Т.к. объект ссылается на Lion
         */
        catFamily2.eat();


    }

}


abstract class CatFamily {
    int ears;
    int legs;

    public CatFamily(int ears, int legs) {
        this.ears = ears;
        this.legs = legs;
    }

    /**
     * @return CharSequence
     */
    protected CharSequence showInfo() {
        return "Количество ушей " + ears + " Количество лап " + legs;
    }

    public void eat() {
        System.out.println("Eating");
    }
}


class Lion extends CatFamily {

    public Lion(Integer ears, Integer legs) {
        /**
         * вызов родительского конструктора
         */
        super(ears, legs);
    }


    /**
     * Переопределив метод родительского класса, необходимо указать аннотацию [Override]
     * сама аннотация нечего не делать, а только дает понять, что этот метод был переопределен,
     * а не новый какой-то, так же нежен для того что если мы напишем неправильное название метода
     * которого нет в родительском, то она выдасть ошибку
     * <p>
     * Method overriding - это изменение non-static, non-final метода в sub - классе, который унаследовал от parent класса
     * Методы считаются overriden, если:
     * 1. Имя в sub классе такое же что и в parent классе.
     * 2. Список аргументов в sub классе такое же что и в parent классе.
     * 3. Return type в sub классе такое же что и в parent классе или же
     */
    @Override
    public void eat() {
        System.out.println("Lion eat antelope");
    }

    /**
     * 4. Return type в sub классе - это sub класс Return type из parent класса (covariant return types).
     * [Например, вместо CharSequence, я возвращаю String(т.к он наследник CharSequence)]
     * 5. Access modifier в sub классе должен быть такой же или менее строгий чем в parent классе
     * [Например, в parent классе , был protected, в sub классе сделали public(менее строгий) . Default, Private не подходят]
     * 6. Метод в sub классе тоже должен быть non-static
     * 7. Понятие variable overriding не существует. Пере определиться могут только методы.
     */
    @Override
    public String showInfo() {
        return "У льва количество ушей" + ears + " Количество лап " + legs;
    }
}

class Cat extends CatFamily {

    public Cat() {
        super(2, 4);
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("Cat eat a mouse");
    }
}

/**
 * final class - не могут иметь наследников
 */
final class Tiger extends CatFamily{

    public Tiger(int ears, int legs) {
        super(ears, legs);
    }
}

