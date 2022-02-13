package oop.inheriate.example;

/**
 * Created by Osman on 11:52 AM
 */
public class Rect extends Figure {


    public Rect(int a, int b, int c, int d) {
        super(a, b);

    }

    public Rect(int size) {
        super(size, size);

    }

    @Override
    public void area() {

        double area = a*b;
        System.out.println("Area size: "+area);
    }
}
