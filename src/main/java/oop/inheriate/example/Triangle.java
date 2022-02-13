package oop.inheriate.example;

/**
 * Created by Osman on 11:55 AM
 */
public class Triangle extends Figure {

    int c;

    public Triangle(int a, int b, int c) {
        super(a, b);
        this.c = c;
    }

    public Triangle(int size){
        super(size,size);
        this.c = size;
    }

    @Override
    public void area() {
        int p = (a + b + c ) / 2;
        double area = Math.sqrt(p * (p - a) * (p - b) * (p - c) );
        System.out.println("Area size: "+area);
    }

}
