package clazz.nested;

public class NestedStaticClass {

    public static void main(String[] args) {
        Car car = new Car();
        Car.Engine engine = new Car.Engine();
    }

}

class Car {

    /**
     * nested static class - вложенный статический класс, для создания объекта статического класса не нужно создать
     * объект внешнего класса Car, Нужно указать имя класса внешнего класса и через точку имя вложенного
     * статического класса
     *
     * static nested класс очень похож на обычный внешний, но находится внутри другого класса
     * • Создавая объект static nested класса, нужно указывать и класс, содержащий его
     * • static nested класс может содержать static и non-static элементы
     * • static nested класс может обращаться даже к private элементам внешнего класса, но только к static
     * • Внешний класс может обращаться даже к private static элементам nested класса
     */
    public static class Engine {
    }

}
