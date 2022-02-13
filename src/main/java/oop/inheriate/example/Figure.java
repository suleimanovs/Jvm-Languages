package oop.inheriate.example;

/**
 * Created by Osman on 11:46 AM
 */
public abstract class Figure {
    int a;
    int b;

    public Figure(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public abstract void area();

    /**
     * если мы не хотим что бы наш метод был доступен для переопределения, то нужно его
     * пометиь как [final]
     */
}
