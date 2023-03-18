package delegate.introduction.java;

/**
 * Паттерн делегат очень простой:один объект передает выполнение своего метода другому объекту.
 * Например,в Java это выглядит так:
 */
interface Flyable {
    void flyToRight();

    void flyToLeft();
}

final class Plane implements Flyable {

    @Override
    public void flyToRight() {
        System.out.println("Лечу на право!");
    }

    @Override
    public void flyToLeft() {
        System.out.println("Лечу на лево!");

    }
}

/**
 * 1.Теперь во первых мы должны писать код на уровне абстракций, а не реализаций.
 * 2.Так же, что если класс, чей код мы хотим наследовать, можем быть как final(запрещен для наследования)
 * 3.Что если наш класс уже имеет родителя, то есть уже наследован от какого-то класса, то мы не можем наследоваться
 * от двух классов одновременно.
 * В таких случаях на помощь приходит паттерн Делегирование.
 * Тоже самое но в Kotlin: {@link delegate.introduction.kotlin.KotlinTestFlyableKt}
 */

final class Bird implements Flyable {
    private final Flyable flyable;

    public Bird(Flyable flyable) {
        this.flyable = flyable;
    }

    // здесь мы используем готовую реализацию, и при этом мы это делаем на уровне абстракций.
    @Override
    public void flyToRight() {
        flyable.flyToRight();
    }

    // тут мы создали свою реализацию.
    @Override
    public void flyToLeft() {
        System.out.println("Лечу на лево опускаясь ниже!");
    }
}

public final class JavaTestFlyable {
    public static void main(String[] args) {
        Flyable flyable = new Plane(); //конкретная реализация интерфейса Flyable
        Bird bird = new Bird(flyable); //передаем объект типа Flyable
        bird.flyToLeft(); // реализация из класса Plane
        bird.flyToRight(); //наша собственная реализация.
    }

}





