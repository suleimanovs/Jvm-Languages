package oop.box;

/**
 * Created by Osman on 15:00
 */
public class Box {
    double width;
    double height;
    double length;


    //пустой конструктор
    public Box() {
        width = 0;
        height = 0;
        length = 0;
    }

    public Box(double size) {
        width = size;
        height = size;
        length = size;
    }

    public Box(double width, double height, double length) {
        this.width = width;
        this.length = length;
        this.height = height;
    }

    public Box(Box box) {
        this.length = box.length;
        this.width = box.width;
        this.height = box.height;
    }


    double volume() {
        return width * height * length;
    }

    int compare(Box box) {
        double thisVolume = volume();
        double boxVolume = box.volume();

        if (thisVolume > boxVolume) return 1;
        else if (thisVolume < boxVolume) return -1;
        else return 0;


    }

    public Box boxMaker(Box box) {
        return new Box(
                this.width + box.width,
                this.height + box.height,
                this.length + box.length
        );
    }

    @Override
    public String toString() {
        return "Box{" +
                "width=" + width +
                ", height=" + height +
                ", length=" + length +
                '}';
    }


}
