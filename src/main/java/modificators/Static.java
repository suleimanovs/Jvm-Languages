package modificators;


class Car {

    String name;
    static int count;
    static final int MODEL_VERSION = 4;

    Car(String name) {
        this.name = name;
        /**
         * static переменные не относятся к обьекту, они пренадлежать классу
         * инкремент данной переменной id будет происходит при каждом созданий обьекта,
         * таким образом мы узнаем сколько объектов данного класса было создано
         */
        count++;
    }

    /**
     * @static - для его вызова не нужно создать обьект класса
     * статические методы не могут ссылаться на перременные экземпляра,
     * они должны ссылатся на такие же статические переменные
     */
    public static void getModelVersion() {
        System.out.println(MODEL_VERSION);
    }
}

public class Static {

    /**
     * static элементы: переменные, методы не могут вызывать, обращаться к instance переменным и методам
     * к static элементам принято обращаться используя имя класса, а не ссылку на созданный объект.
     */
    public static void main(String[] args) {
        Car car1 = new Car("Toyota");
        Car car2 = new Car("BMW");
        Car car3 = new Car("Lexus");


        int count = Car.count; // можно обращаться к static полям без создания объекта
        Car.getModelVersion(); // можно обращаться к static методом без создания объекта
        car3.getModelVersion(); // можно обращаться к static методом c объекта

        System.out.println(count + "- машин было создано");

    }
}
