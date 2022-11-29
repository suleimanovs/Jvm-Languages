package clazz.nested;

public class InnerClass {

    public static void main(String[] args) {
        InnerCar innerCar = new InnerCar();
        InnerCar.InnerEngine innerEngine = innerCar.new InnerEngine();
    }

}


class InnerCar {

    /**
     * inner class - внутренний класс, для создания объекта такого класса  нужно создать
     * объект внешнего класса InnerCar,
     * <p>
     * Каждый объект inner класса всегда ассоциируется с объектом внешнего класса
     * Создавая объект inner класса, нужно перед этим создать объект его внешнего класса
     * • Inner класс может содержать только non-static элементы
     * • Inner класс может обращаться даже к private элементам внешнего класса
     * • Внешний класс может обращаться даже к private элементам inner класса, прежде создав его объект
     */
    public class InnerEngine {
    }

}

